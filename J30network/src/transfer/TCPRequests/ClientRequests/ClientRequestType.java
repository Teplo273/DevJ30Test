package transfer.TCPRequests.ClientRequests;

import java.io.Serializable;

public enum ClientRequestType implements Serializable{
    GetList, FindByName, SaveItem, DeleteItem, Disconnect;
}
