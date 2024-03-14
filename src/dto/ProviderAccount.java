package dto;

import enums.CommunicationType;

import java.util.List;

public class ProviderAccount {
    private String username;
    private String password;

    private String accountId;
    private List<CommunicationType> type;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public List<CommunicationType> getType() {
        return type;
    }

    public void setType(List<CommunicationType> type) {
        this.type = type;
    }

    public ProviderAccount(String username, String password, String accountId, List<CommunicationType> type) {
        this.username = username;
        this.password = password;
        this.accountId = accountId;
        this.type = type;
    }

    @Override
    public String toString() {
        return "ProviderAccount{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountId='" + accountId + '\'' +
                ", type=" + type +
                '}';
    }
}
