package services;

import dto.CommunicationRequest;
import dto.Provider;
import dto.ProviderAccount;
import enums.CommunicationType;

import java.util.*;

public class CommunicationService {

    private static CommunicationService instance;
    private List<Provider> providers;

    private Map<String, Integer> providersMap;

    // Private constructor to prevent instantiation from outside
    private CommunicationService() {
        this.providers = new ArrayList<>();
        this.providersMap = new HashMap<>();
    }

    // Static method to get the singleton instance
    public static CommunicationService getInstance() {
        if (instance == null) {
            instance = new CommunicationService();
        }
        return instance;
    }
    public void addProvider(Provider provider) {
        String providerId = provider.getProviderId();
        if(providersMap.containsKey(providerId)){
            System.out.println("ERROR: The provider already exists.");
        }else{
            providers.add(provider);
            providersMap.put(providerId, providers.size()-1);
        }
    }

    public Provider getProvider(String providerId) {
        if(providersMap.containsKey(providerId)) {
            return providers.get(providersMap.get(providerId));
        }
        else{
            System.out.println("ERROR: The provider does not exist.");
            return null;
        }
    }

    public void updateState(String providerId, boolean active) {
        if(providersMap.containsKey(providerId)) {
            int index = providersMap.get(providerId);
            Provider provider = providers.get(index);
            provider.setActive(active);
            providers.set(index, provider);
        }
        else{
            System.out.println("ERROR: The provider does not exist.");
        }
    }

    public void updateProvider(Provider updatedProvider) {
        String providerId = updatedProvider.getProviderId();
        if(providersMap.containsKey(providerId)) { // Check if map contains the providerId
            int index = providersMap.get(providerId); // Fetch the index of the provider with id providerId
            providers.set(index, updatedProvider); // Set the index with updatedProvided
        }
        else{
            System.out.println("ERROR: The provider which you want to update does not exist.");
        }
    }

    public void processRequest(CommunicationRequest request) {
        List<Provider> activeProviders = new ArrayList<>();
        // Collect all the active providers
        for (Provider provider : providers) {
            if (provider.isActive()) {
                activeProviders.add(provider);
            }
        }

        if (!activeProviders.isEmpty()) {
            Provider chosenProvider = activeProviders.get(new Random().nextInt(activeProviders.size()));
            String providerId = chosenProvider.getProviderId();

            String apiEndpoint = chosenProvider.getApiEndpoints().get(request.getType());
            ProviderAccount account = getAccountForChannel(chosenProvider, request.getType());
            if (account != null) {
                // Retrieve username and password from the account
                String username = account.getUsername();
                String password = account.getPassword();

                // Perform the API call using the authentication details
                System.out.println("Sending request to provider " + providerId + " via API endpoint " + apiEndpoint);
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println("Request data: " + request.getData());
            } else {
                System.out.println("No account found for the requested communication type.");
            }
        } else {
            System.out.println("No active providers available for processing the request.");
        }
    }

    // Helper method to get the appropriate account for the given channel from the chosen provider
    private ProviderAccount getAccountForChannel(Provider provider, CommunicationType type) {
        List<ProviderAccount> accounts = provider.getAccounts();
        if(accounts==null) return null;
        for (ProviderAccount account : accounts) {
            if (account.getType().contains(type)) {
                return account;
            }
        }
        return null;
    }
}
