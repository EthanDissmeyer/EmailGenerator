// @ts-check
import { defineConfig, devices } from '@playwright/test';

/**
 * @see https://playwright.dev/docs/test-configuration
 */
export default defineConfig({
  testDir: './tests',
  fullyParallel: true,
  forbidOnly: !!process.env.CI,
  retries: process.env.CI ? 2 : 0,
  workers: process.env.CI ? 1 : undefined,
  reporter: [['html', { outputFolder: 'playwright-report' }]],

  use: {
    trace: 'on-first-retry',
    headless: true, 
  },

  projects: [
    {
      name: 'chromium',
      use: {
        ...devices['Desktop Chrome'], 
      },
    },
  ],
});
