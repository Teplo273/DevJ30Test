package j30client.gui;

public interface GUI {
    
    /**
     * Set Connection Label at the bottom of Frame
     * @param isConnected 
     */
    public void setConnectionLabel(Boolean isConnected);
    
    /**
     * Print service message to log panel
     * @param message 
     */
    public void printStatus(String message);
    
    public void OpenOptionFrame();
    
    
}
