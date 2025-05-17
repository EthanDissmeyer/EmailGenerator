class EmailGeneratorPage {
    /**
    * @param {import('@playwright/test').Page} page
    */
    constructor(page) {
        this.page = page;
        this.emailGeneratorButton = page.getByRole('link', { name: 'Email Generator' });
        this.homeButton = page.getByRole('link', { name: 'Home' });
    }

    async goto() {
        await this.page.goto('http://localhost:4200/email-generator');
    }
}

module.exports = { EmailGeneratorPage };
