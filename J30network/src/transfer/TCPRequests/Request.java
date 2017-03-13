package transfer.TCPRequests;

import transfer.objects.DictionaryItem;

public enum Request {
    FindByEng, FindByRus, SaveItem, DeleteItem, Disconnect;
    
    private String command;
    private DictionaryItem item;
    private int id;

    public int getId() {
        return id;
    }

    public DictionaryItem getItem() {
        return item;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }
    
    public void setItem(DictionaryItem item) {
        this.item = item;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
}
