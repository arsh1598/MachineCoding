import dto.CommunicationRequest;
import dto.Provider;
import dto.ProviderAccount;
import enums.CommunicationType;
import services.CommunicationService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Sample
        CommunicationService communicationService = CommunicationService.getInstance();

        Map<CommunicationType, String> apiEndpoints = new HashMap<>();
        apiEndpoints.put(CommunicationType.EMAIL, "https://phonepe.com/email/send");
        apiEndpoints.put(CommunicationType.SMS, "https://phonepe.com/sms/send");
        List<ProviderAccount> accounts = new ArrayList<>();

        List<CommunicationType> emailType = new ArrayList<>();
        emailType.add(CommunicationType.EMAIL);

        List<CommunicationType> smsType = new ArrayList<>();
        smsType.add(CommunicationType.SMS);

        List<CommunicationType> soundBoxType = new ArrayList<>();
        soundBoxType.add(CommunicationType.SOUNDBOX);

        ProviderAccount emailAccount = new ProviderAccount("emailUsername", "Password", "acountId1", emailType);
        ProviderAccount smsAccount = new ProviderAccount("smsUsername", "Password", "acountId2", smsType);
        ProviderAccount soundBoxAccount = new ProviderAccount("soundBoxUsername", "Password", "acountId3", soundBoxType);

        accounts.add(emailAccount);
        accounts.add(smsAccount);
        accounts.add(soundBoxAccount);
        Provider provider1 = new Provider("provider1", true, accounts, apiEndpoints);
        // Add provider
        communicationService.addProvider(provider1);

        Map<String, String> requestData1 = new HashMap<>();
        requestData1.put("sender", "sender@phonepe.com");
        requestData1.put("receiver", "receiver@phonepe.com");
        requestData1.put("subject", "EMAIL subject");
        requestData1.put("message", "EMAIL message");
        CommunicationRequest request1 = new CommunicationRequest(CommunicationType.EMAIL, requestData1);
        Map<String, String> requestData2 = new HashMap<>();
        requestData2.put("number", "1234567890");
        requestData2.put("message", "sms message");
        CommunicationRequest request2 = new CommunicationRequest(CommunicationType.SMS, requestData2);

        // Process the request
        communicationService.processRequest(request1);
        System.out.println("======================\n");
        communicationService.processRequest(request2);
        System.out.println("======================\n");
        // Updating status to false so that no active providers are available
        communicationService.updateState("provider1", false);
        communicationService.processRequest(request1);
        System.out.println("======================\n");
        // Updating status back to true
        communicationService.updateState("provider1", true);
        // Setting this to null so that no providerAccounts are there
        provider1.setAccounts(null);
        communicationService.updateProvider(provider1);
        communicationService.processRequest(request1);
    }
}