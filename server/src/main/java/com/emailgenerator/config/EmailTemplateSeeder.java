package com.emailgenerator.config;

import com.emailgenerator.model.EmailTemplate;
import com.emailgenerator.repository.EmailTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class EmailTemplateSeeder {

    private final EmailTemplateRepository repository;

    @Autowired
    public EmailTemplateSeeder(EmailTemplateRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void seed() {
        if (repository.count() > 0) return;

        saveTemplate("New Business Nature and Scope", "Our next steps for your Insurance Cover", "New Client", """
            It was great to speak to/meet you today/yesterday/date to discuss your insurance needs. We believe in creating a fantastic client experience and will work tirelessly to provide personal service and quality advice for you.

            Before we progress to finding the best insurance cover for you, it is important for me to outline our next steps and present you with our Terms of Business. [Attach Terms of Business]

            This sets out how we will work on your behalf to help ensure you have the right insurance cover in place. It also contains information about how we are remunerated, your obligations and responsibilities and other aspects of our prospective relationship.

            As a Financial Advisor, I am authorised to provide advice on behalf of Rothbury Insurance Brokers and if you accept our Terms of Business, I will act as your Insurance Broker to find the right insurance cover for you.

            Following our conversation, I have included a list of the policy types I will provide you financial advice on:

            · List Policy Types you are giving advice on here.

            ** Delete if No limitations**

            I also mentioned there are some aspects that I cannot provide you with advice on. These are:

            · List Limitations here.

            ------------------------------------------ You can find more about our insurer partners and the products we provide advice on here.

            In case you have any questions or would like to discuss any changes to your insurance needs, my contact information is attached. [Attach Your Service Team]

            I look forward to working with you and will be in touch with my recommendations shortly.
        """);

        saveTemplate("Renewal/Endorsement Nature and Scope (Adding New Policy Type)", "Changes to your Insurance Cover", "Renewal", """
            Thank you for taking the time to reach out to discuss the changes in your insurance needs with me today/yesterday/DATE. It was great to hear from you.

            Below is a list of the further policy types I will provide financial advice on:

            · List NEW Policy Types you are giving advice on here.

            ** Delete if No NEW limitations**

            As discussed, there are also some aspects of your new requested cover that I cannot provide insurance advice on. These are:

            · List any NEW Limitations here.

            ------------------------------------------

            Thank you for trusting us with your insurance. If you have any questions or would like to talk to us about your cover, you are welcome to contact me on the details found below. Otherwise, I look forward to working with you and will be in touch with my recommendations shortly.
        """);

        saveTemplate("Client Quote Presentation", "Your Rothbury Insurance Recommendation", "Quotes", """
            It was great to speak to/meet you today/yesterday/date to discuss your insurance needs. Based on our discussion, I have conducted an assessment of suitable options suitable for your insurance needs and risk tolerance. I am happy to present that to you today. [Attach Client Presentation]

            This presentation contains a summary of your insurance quotes, along with my analysis and recommendation for the most suitable cover options to ensure you have the best cover in place for your needs.

            ** Domestic Option**

            If you would like me to proceed with any of these recommendations, please let me know which insurer(s) and excess options you would like. I am also happy to discuss them further or provide any additional information or quotes you may need.

            ------------------------------------------

            **Commercial Option** If you would like me to proceed with any of these recommendations, please let me know which insurer(s) and excess options you would like and please complete the Rothbury Letter of Appointment found here/attached.

            I am also happy to discuss them further or provide any additional information or quotes you may need.

            ------------------------------------------

            **Add Summary of Recommendation (Optional)**

            Thank you for trusting Rothbury Insurance Brokers with your Commercial/Domestic Insurance needs. If you have any questions or would like to talk about your insurance cover, my contact details can be found in the Your Service Team page of my recommendation. Otherwise, I will follow up shortly to discuss my recommendations and confirm which covers you would like me place.
        """);

        saveTemplate("Proposal Reminder", "We haven’t heard from you about your proposal form.", "Proposal Reminder", """
            Thank you for trusting us with your Commercial/Domestic insurance needs. We’ve noticed that your Insurance Proposal form hasn’t been returned to us yet.

            Could you please complete the attached/linked proposal form and return it to me within the next 28 business days. The Proposal form is an important part of ensuring that your insurance requirements are correctly put in place and must be completed, signed, and returned to me before the start of your insurance cover.

            If you have any questions, or would like help completing the form, please get in touch. My Contact details can be found below, and I look forward to hearing from you.
        """);

        saveTemplate("Renewal Declaration Reminder", "We haven’t received your Renewal Declaration?", "Renewal", """
            Thank you for trusting us with your Domestic/Commercial Insurance needs. We’ve noticed that we haven’t received your Insurance Renewal Declaration yet.

            The terms provided for your renewing Policies are provisional on your declaration being completed in full and sent to the Insurer. This is an important part of making sure your insurance requirements are correctly put in place.

            Could you please complete the attached form and return it to me within the next 7 days or alternatively, you can call me with the details.

            If you have any questions, or would like help completing the form, please get in touch with me. My Contact details can be found below, and I look forward to hearing from you.
        """);

        saveTemplate("Confirmation Email: New Business", "Welcome aboard – Confirming your New Insurance Cover", "Confirmation Email", """
            I am happy to confirm that your new insurance cover is now in place and is effective from Date to Date. Thank you for choosing Rothbury Insurance Brokers to manage your Commercial/Domestic Insurance Needs.

            As agreed, I have placed the following policies on your behalf:

            · ENTER Policies Placed – INSURER

            · ENTER Policies Placed – INSURER

            Please take the time to read the attached documents to make sure the cover arranged meets your needs, and all the details are correct:

            · Tax Invoice

            · Package Schedule(s) – this contains a detailed summary of your Insurance Cover, the extensions and other information specific to your policies.

            · Policy Wording(s)

            **DELETE AS APPLICABLE**

            My Rothbury App

            My Rothbury App gives you access to your domestic/commercial insurance information so you can check your policy details, sum insured and excesses at any time. You can start a claim, receive claim updates, and pay your insurance cover at the touch of a button.

            If you haven’t already, download My Rothbury in the App Store or Google Play Store today.

            ------------------------------------

            **DELETE AS APPLICABLE- ANNUAL only**

            Payment Information

            You can make online insurance payments directly through your Tax Invoice, just click on your preferred payment option.

            ------------------------------------

            **DELETE AS APPLICABLE- FUNDED only**

            Rothbury Instalment Services

            Rothbury Instalment Services allows you to pay your insurance invoices in easy to manage instalments. You can click on the link provided to complete your finance agreement online. Rothbury Instalments Services will fund your insurance invoice on your behalf, and you repay Rothbury Instalments Services on a payment frequency that suits you (interest and an establishment fee will apply). Once we receive the completed documents, your nominated account will be debited to bring your payments up to date.

            ------------------------------------

            **DELETE AS APPLICABLE* Commercial only*

            Uninsured Risks

            I have identified several risks your business may be exposed to and have outlined these in the attached uninsured risk checklist. I would be happy to discuss these with you at any time.

            ------------------------------------

            Duty of Disclosure

            You have a duty to disclose to the Insurer all information that may influence its decision to insure you and set the terms and premium of your policy. This duty applies prior to the commencement, variation, and renewal of your insurance policy. If you do not disclose all such information your policy may be voided which means it will be treated as though it never existed, and any claims will not be payable.

            Your feedback is important to us.

            We are always looking for ways to improve our service and would love your feedback. You may receive a survey shortly which we would appreciate if you could please complete. The measurement 1 to 6 indicates our service is below average, 7 to 8 are average, and 9 to 10 are above average.

            Thank you for trusting Rothbury Insurance Brokers with your insurance, if you have any questions or would like to talk about your insurance cover, my contact details can be found below, on your invoice, or in the Your Service Team page of your Presentation.
        """);

        saveTemplate("Confirmation Email: Renewal (Contacted Client)", "Confirming your Insurance Cover Renewal.", "Renewal", """
            It was great to discuss your renewal insurance requirements with you on Date. Thank you for continuing to trust Rothbury Insurance Brokers with your Commercial/Domestic Insurance needs.

            I’m pleased to confirm that we have renewed your insurance cover for the coming year, effective from DATE to DATE. I have renewed the following policies on your behalf:

            · ENTER Policies Placed – INSURER

            · ENTER Policies Placed – INSURER

            Please take the time to read the attached documents to make sure the cover arranged meets your needs, and all the details are correct:

            · Tax Invoice

            · Package Schedule

            · Policy Wording(s)

            · Updated Payment Schedule (Funded only).

            **DELETE AS APPLICABLE**

            My Rothbury App

            My Rothbury App gives you access to your domestic/commercial insurance information so you can check your policy details, sum insured and excesses at any time. You can start a claim, receive claim updates, and pay your insurance cover at the touch of a button.

            If you haven’t already, download My Rothbury in the App Store or Google Play Store today.

            ------------------------------------

            **DELETE AS APPLICABLE- ANNUAL only**

            Payment Information

            You can make online insurance payments directly through your Tax Invoice, just click on your preferred payment option.

            ------------------------------------

            **DELETE AS APPLICABLE- FUNDED only**

            Payment Information

            As one of our Rothbury Instalment Services clients, your instalment agreement has been automatically renewed, and you don’t need to do anything further. Rothbury Instalment Services will continue to pay your insurance invoice on your behalf to help free up your cash flow.


            If you do not wish to renew your instalment agreement with Rothbury Instalment Services, please let me know.

            ------------------------------------

            Duty of Disclosure

            You have a duty to disclose to the Insurer all information that may influence its decision to insure you and set the terms and premium of your policy. This duty applies prior to the commencement, variation, and renewal of your insurance policy. If you do not disclose all such information your policy may be voided which means it will be treated as though it never existed, and any claims will not be payable.

            Your feedback is important to us.

            We are always looking for ways to improve our service and would love your feedback. You may receive a survey shortly which we would appreciate if you could please complete. The measurement 1 to 6 indicates our service is below average, 7 to 8 are average, and 9 to 10 are above average.

            We are grateful for the opportunity to arrange your insurance cover, if you have any questions or would like to talk about your insurance cover, my contact details can be found below, in the Your Service Team page of your Presentation or on your invoice.
        """);

        saveTemplate("Confirmation Email: Renewal (Uncontacted Client)", "Confirming your Insurance Renewal.", "Renewal", """
            Your domestic insurance renewal with Rothbury is coming up on DATE. We have been unsuccessful in speaking with you regarding your future insurance needs. However, to ensure you remain covered, I have renewed your policies for a further 12 months. This has been completed based on information from last year’s renewal and have attached this information for you to review. A summary can be found below:

            · ENTER Policies Placed – INSURER

            · ENTER Policies Placed – INSURER

            It’s important to make sure the insurance cover you have in place continues to meet your needs, so I recommend completing a review of your renewed policies. I would be happy to do this with you either in person, or over the phone at a time that suits you.

            Please find the following documents attached to this email.

            · Tax Invoice.

            · Package Schedule.

            · Updated Payment Schedule (Funded only).

            You are welcome to let me know about any changes to your insurance using my contact details found below, or on your invoice.

            **DELETE AS APPLICABLE**

            My Rothbury App

            My Rothbury App gives you access to your personal/commercial insurance information so you can check your policy details, sum insured and excesses at any time. You can start a claim, receive claim updates, and pay your insurance cover at the touch of a button.

            If you haven’t already, download My Rothbury in the App Store or Google Play Store today.

            ------------------------------------

            **DELETE AS APPLICABLE- ANNUAL only**

            Payment Information

            You can make online insurance payments directly through your Tax Invoice, just click on your preferred payment option.

            ------------------------------------

            **DELETE AS APPLICABLE- FUNDED only**

            Payment Information

            As one of our Rothbury Instalment Services clients, your instalment agreement has been automatically renewed, and you don’t need to do anything further. Rothbury Instalment Services will continue to pay your insurance invoice on your behalf to help free up your cash flow.

            If you do not wish to renew your instalment agreement with Rothbury Instalment Services, please let me know.

            ------------------------------------

            Duty of Disclosure

            You have a duty to disclose to the Insurer all information that may influence its decision to insure you and set the terms and premium of your policy. This duty applies prior to the commencement, variation, and renewal of your insurance policy. If you do not disclose all such information your policy may be voided which means it will be treated as though it never existed, and any claims will not be payable.

            Your feedback is important to us.

            We are always looking for ways to improve our service and would love your feedback. You may receive a survey shortly which we would appreciate if you could please complete. The measurement 1 to 6 indicates our service is below average, 7 to 8 are average, and 9 to 10 are above average.

            We are grateful for the opportunity to arrange your insurance cover, if you have any questions or would like to talk about your insurance cover, my contact details can be found below, in the Your Service Team page of your Presentation or on your invoice.
        """);

        saveTemplate("Confirmation Email: Renewal (Rental Property)", "Confirming your Insurance Renewal.", "Renewal", """
            It was great to discuss your Insurance Renewal with you on Date. Thank you for continuing to trust Rothbury Insurance Brokers with your Domestic Insurance needs.

            I’m pleased to confirm that we have renewed your insurance cover for the coming year, effective from DATE to DATE. I have placed the following policies on your behalf:

            · ENTER Policies Placed – INSURER

            · ENTER Policies Placed – INSURER

            Please take the time to read the attached documents to make sure the cover meets your needs, and all the details are correct:

            · Tax Invoice

            · Package Schedule

            · Policy Wording(s)

            Rental Property Important Information

            I would also like to outline the following terms and conditions that apply to your rental property:

            Additional rental property $XXX excess applies.

            60 Day Unoccupancy: You must notify us if your property is likely to be unoccupied for over 60 days. If we are not notified, this could affect the outcome of any claim.

            As a landlord, you have obligations to fulfil to be able to claim for benefits under your policy. A written tenancy agreement is required, you (or your property manager) must exercise reasonable care in tenant selection (references must be obtained, records of checks undertaken, and copies must be available). This includes regular property inspections, photos and written records of inspections must be kept.

            If your rental property is professionally managed, we suggest you ensure your property manager is aware of these obligations.

            Your policy includes EDIT AS REQUIRED

            · Landlords’ extension

            **DELETE AS APPLICABLE**

            My Rothbury App

            My Rothbury App gives you access to your domestic insurance information so you can check your policy details, sum insured and excesses at any time. You can start a claim, receive claim updates, and pay your insurance cover at the touch of a button.

            If you haven’t already, download My Rothbury in the App Store or Google Play Store today.

            ------------------------------------

            **DELETE AS APPLICABLE- ANNUAL only**

            Payment Information

            You can make online insurance payments directly through your Tax Invoice, just click on your preferred payment option.

            ------------------------------------

            **DELETE AS APPLICABLE- FUNDED only**

            Payment Information

            As one of our Rothbury Instalment Services clients, your instalment agreement has been automatically renewed, and you don’t need to do anything further. Rothbury Instalment Services will continue to pay your insurance invoice on your behalf to help free up your cash flow.

            If you do not wish to renew your instalment agreement with Rothbury Instalment Services, please let me know.

            ------------------------------------

            Duty of Disclosure

            You have a duty to disclose to the Insurer all information that may influence its decision to insure you and set the terms and premium of your policy. This duty applies prior to the commencement, variation, and renewal of your insurance policy. If you do not disclose all such information your policy may be voided which means it will be treated as though it never existed, and any claims will not be payable.

            Your feedback is important to us.

            We are always looking for ways to improve our service and would love your feedback. You may receive a survey shortly which we would appreciate if you could please complete. The measurement 1 to 6 indicates our service is below average, 7 to 8 are average, and 9 to 10 are above average.

            We are grateful for the opportunity to arrange your insurance cover, if you have any questions or would like to talk about your insurance cover, my contact details can be found below, in the Your Service Team page of your Presentation or on your invoice.
         """);

        saveTemplate("Confirmation Email: Endorsement", "We’ve processed your Insurance Cover change.", "Endorsement", """
            It was great to discuss the changes to your Insurance cover with you on Date. I am happy to confirm that your updated insurance cover is now in place and is effective from Date to Date. Thank you for trusting Rothbury Insurance Brokers to manage your Commercial/Domestic Insurance needs.

            As agreed, I have placed/made changes to the following policies on your behalf:

            · ENTER Policies Placed/changed – INSURER.

            · ENTER Policies Placed/changed – INSURER.

            Please find the following documents attached to this email.

            · Tax Invoice.

            · Updated Package Schedule.

            · Updated Payment Schedule (Funded only).

            · Commercial/Domestic Endorsement Important Information – Only for New Insurer

            My Rothbury App

            My Rothbury App gives you access to your /commercial insurance information so you can check your policy details, sum insured and excesses at any time. You can start a claim, receive claim updates, and pay your insurance cover at the touch of a button.

            If you haven’t already, download My Rothbury in the App Store or Google Play Store today.

            **DELETE AS APPLICABLE- ANNUAL only**

            Payment Information

            You can make online insurance payments directly through your Tax Invoice, just click on your preferred payment option.

            ------------------------------------

            **DELETE AS APPLICABLE- FUNDED only**

            Payment Information

            As one of our Rothbury Instalment Services clients, your instalment agreement has been automatically renewed, and you don’t need to do anything further. Rothbury Instalment Services will continue to pay your insurance invoice on your behalf to help free up your cash flow.

            If you do not wish to renew your instalment agreement with Rothbury Instalment Services, please let me know.

            Refund Information

            Our preferred method for refunds is via direct credit, please contact me with your bank account details.

            ------------------------------------

            Duty of Disclosure

            You have a duty to disclose to the Insurer all information that may influence its decision to insure you and set the terms and premium of your policy. This duty applies prior to the commencement, variation, and renewal of your insurance policy. If you do not disclose all such information your policy may be voided which means it will be treated as though it never existed, and any claims will not be payable.

            Your feedback is important to us.

            We are always looking for ways to improve our service and would love your feedback. You may receive a survey shortly which we would appreciate if you could please complete. The measurement 1 to 6 indicates our service is below average, 7 to 8 are average, and 9 to 10 are above average.

            We are grateful for the opportunity to arrange your insurance cover, if you have any questions or would like to talk about further changes to your insurance cover, my contact details can be found below, in the Your Service Team page of your Presentation and on your invoice.
        """);

        saveTemplate("Confirmation Email: Cancellation", "Confirming your insurance cancellation.", "Confirmation Email", """
            It was great to discuss the changes to your Insurance cover with you on Date. Thank you for getting in touch with me to discuss your Commercial/Domestic Insurance cover with us.

            We have received your request to cancel your Commercial/Domestic Insurance cover with us, and I can confirm that the following policies have been cancelled on your behalf.

            · ENTER POLICY & EFFECTIVE DATE

            We’re sorry to see you go and hope to be able to assist you again in the future with your insurance.

            We are committed to providing personal service and quality advice. If you have any questions or have any concerns about your future insurance cover, please get in touch.

            Kind regards,        
        """);
    }

    private void saveTemplate(String name, String subject, String type, String body) {
        EmailTemplate template = new EmailTemplate();
        template.setName(name);
        template.setSubject(subject);
        template.setTransactionType(type);
        template.setBody(body);
        repository.save(template);
    }
}
