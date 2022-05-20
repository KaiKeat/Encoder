public class Decode extends Cryptography{
    private String plainText;
    public Decode() {
        this.plainText = null;
    }

    public String decode(String encodedText) {
        char[] encodedTextToChar = encodedText.toUpperCase().toCharArray();
        int offsetIndex = super.findOffsetIndex(encodedTextToChar[0]);
        String plainText = "";
        int index = 0;
        boolean isInside;
        for(int i = 1; i < encodedTextToChar.length; i++) {
            isInside = false;
            for (int j = 0; j < getReferenceTable().length; j++) {
                if (encodedTextToChar[i] == getReferenceTable()[j]) {
                    isInside = true;
                    index = j + offsetIndex;
                }
            }
            if (isInside) {
                if (index > getReferenceTable().length-1) {
                    index -= (getReferenceTable().length);
                    plainText+=getReferenceTable()[index];
                } else {
                    plainText+=getReferenceTable()[index];
                }
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
