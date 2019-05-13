package model;

import java.util.List;

public interface ConnectAbleNetworkPart{
    int getUsedPower();
    List<? extends ConnectAbleNetworkPart> getConnectedParts();
    void plugIn(ConnectAbleNetworkPart plugging);
}
