import {test, expect} from '@playwright/test'
const { EmailGeneratorPage } = require('../pages/emailGeneratorPage');

test('validate buttons appear on template page', async({page}) => {
    const emailPage = new EmailGeneratorPage(page);
    await emailPage.goto();

    await expect(emailPage.emailGeneratorButton).toBeVisible();
    await expect(emailPage.homeButton).toBeVisible();
});

test('select RedCorp from the dropdown', async({page}) => {

    const emailPage = new EmailGeneratorPage(page)
    await emailPage.goto()

    await page.getByText('Select a client').click();
    await page.getByText('Red Corp').click();
    await expect(page.getByText('Red Corp')).toBeVisible();
});