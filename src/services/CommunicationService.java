package services;

import dto.CommunicationRequest;
import dto.Provider;

public interface CommunicationService {
    public void addProvider(Provider provider);

    public Provider getProvider(String providerId);

    public void updateState(String providerId, boolean active);

    public void updateProvider(Provider updatedProvider);

    public void processRequest(CommunicationRequest request);
}
