package org.example;

public class FictionContext {

    private FictionHandler fictionHandler;

    private String metadata;

    public FictionContext(FictionHandler fictionHandler) {
        this.fictionHandler = fictionHandler;
    }

    public String getMetadata() {
        return metadata;
    }

    public void dispatchScienceFiction() {
        metadata = "science fiction";
        fictionHandler.printScienceFiction();
    }

    public void dispatchFantasy() {
        metadata = "fantasy";
        fictionHandler.printFantasy();
    }

    public void dispatchHistorical() {
        metadata = "historical";
        fictionHandler.printHistorical();
    }

}
