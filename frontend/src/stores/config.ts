/*
 * Copyright 2025 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import { defineStore } from 'pinia'
import { ref, computed } from 'vue'

export interface ConfigState {
  baseUrl: string
  userId: string
  chatId: string
}

export const useConfigStore = defineStore('config', () => {
  // State
  const baseUrl = ref('http://localhost:10008')
  const userId = ref('')
  const chatId = ref('')

  // Getters
  const apiUrl = computed(() => `${baseUrl.value}/api/assistant/chat`)

  // Actions
  function updateConfig(newConfig: Partial<ConfigState>) {
    if (newConfig.baseUrl !== undefined) {
      baseUrl.value = newConfig.baseUrl
    }
    if (newConfig.userId !== undefined) {
      userId.value = newConfig.userId
    }
    if (newConfig.chatId !== undefined) {
      chatId.value = newConfig.chatId
    }
    
    // Save to localStorage
    localStorage.setItem('milk-tea-config', JSON.stringify({
      baseUrl: baseUrl.value,
      userId: userId.value,
      chatId: chatId.value
    }))
  }

  function loadConfig() {
    const saved = localStorage.getItem('milk-tea-config')
    if (saved) {
      try {
        const config = JSON.parse(saved)
        baseUrl.value = config.baseUrl || 'http://localhost:10008'
        userId.value = config.userId || ''
        // 不加载保存的chat_id，每次都重新生成
        chatId.value = ''
      } catch (error) {
        console.error('Failed to load config:', error)
      }
    }
    
    // 每次加载配置时都生成新的chat_id
    generateNewChatId()
  }

  function generateNewChatId() {
    chatId.value = Date.now().toString()
    updateConfig({ chatId: chatId.value })
  }

  function initializeChatId() {
    // 每次初始化都生成新的chat_id
    generateNewChatId()
  }

  return {
    baseUrl,
    userId,
    chatId,
    apiUrl,
    updateConfig,
    loadConfig,
    generateNewChatId,
    initializeChatId
  }
})


