public class Decode extends Cryptography{
    private String plainText;
    public Decode() {
        this.plainText = "";
    }

    public String decode(String encodedText) {
        char[] encodedTextToChar = encodedText.toUpperCase().toCharArray();
        int offsetIndex = super.findOffsetIndex(encodedTextToChar[0]);
        int index;
        for(int i = 1; i < encodedTextToChar.length; i++) {
            index = -1;
            for (int j = 0; j < getReferenceTable().length; j++) {
                if (encodedTextToChar[i] == getReferenceTable()[j]) {
                    index = (j + offsetIndex) % (getReferenceTable().length);
                }
            }
            if (index > -1) {
                plainText+=getReferenceTable()[index];
            } else {
                plainText+=encodedTextToChar[i];
            }
        }
        return plainText;
    }

    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }
}
