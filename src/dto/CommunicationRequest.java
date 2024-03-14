package dto;

import enums.CommunicationType;

import java.util.Map;

public class CommunicationRequest {

    private CommunicationType type;
    private Map<String, String> data;

    public CommunicationType getType() {
        return type;
    }

    public void setType(CommunicationType type) {
        this.type = type;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public CommunicationRequest(CommunicationType type, Map<String, String> data) {
        this.type = type;
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommunicationRequest{" +
                "type=" + type +
                ", data=" + data +
                '}';
    }
}
