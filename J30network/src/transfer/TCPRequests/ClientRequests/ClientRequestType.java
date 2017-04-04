package transfer.TCPRequests.ClientRequests;

import java.io.Serializable;

public enum ClientRequestType implements Serializable{
    GetList, FindItem, SaveItem, DeleteItem, Disconnect;
}
