import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  server: {
    force: true,
    host: true,
    proxy: {
      '/api': {
        changeOrigin: true,
        secure: false,
        target: 'http://192.168.9.147:8080'
      }
    }
  }
})
