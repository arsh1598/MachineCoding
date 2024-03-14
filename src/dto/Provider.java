package dto;

import enums.CommunicationType;

import java.util.List;
import java.util.Map;

public class Provider {

    private String providerId;
    private boolean active;

    private List<ProviderAccount> accounts;

    private Map<CommunicationType, String> apiEndpoints;

    public List<ProviderAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<ProviderAccount> accounts) {
        this.accounts = accounts;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Map<CommunicationType, String> getApiEndpoints() {
        return apiEndpoints;
    }

    public void setApiEndpoints(Map<CommunicationType, String> apiEndpoints) {
        this.apiEndpoints = apiEndpoints;
    }

    public Provider(String providerId, boolean active, List<ProviderAccount> accounts, Map<CommunicationType, String> apiEndpoints) {
        this.providerId = providerId;
        this.active = active;
        this.accounts = accounts;
        this.apiEndpoints = apiEndpoints;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "providerId='" + providerId + '\'' +
                ", active=" + active +
                ", accounts=" + accounts +
                ", apiEndpoints=" + apiEndpoints +
                '}';
    }
}
