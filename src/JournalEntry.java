public class JournalEntry {
    private String timestamp;
    private String text;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JournalEntry(String timestamp, String text) {
        this.timestamp = timestamp;
        this.text = text;
    }
}
