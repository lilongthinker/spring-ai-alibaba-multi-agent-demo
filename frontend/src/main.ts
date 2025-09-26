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

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import Antd from 'ant-design-vue'

import router from './router'
import App from './App.vue'
import 'ant-design-vue/dist/reset.css'
import { i18n } from '@/base/i18n'

import 'nprogress/nprogress.css'

const app = createApp(App)
const pinia = createPinia()

app.use(pinia).use(Antd).use(i18n).use(router)

// Add debugging
console.log('Vue app created, mounting...')
app.mount('#app')
console.log('Vue app mounted')

