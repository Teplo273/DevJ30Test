package transfer.TCPRequests.ClientRequests;

import java.io.Serializable;
import transfer.TCPRequests.RequestType;

public enum ClientRequestTypeImpl implements Serializable, RequestType{
    GetList, FindByEng, FindByRus, SaveItem, DeleteItem, Disconnect;
}
