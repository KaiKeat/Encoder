public class Encode extends Cryptography{
    private String encodedText;
    private char offsetValue;
    private char[] offsetTable;

    public Encode() {
        this.encodedText = null;
        this.offsetValue = 'A';
        this.offsetTable = null;
    }

    public String encode(String plainText) {
        char[] plaintextToChar = plainText.toUpperCase().toCharArray();
        encodedText = String.valueOf(offsetValue);
        int index;
        for (int i = 0; i < plaintextToChar.length; i++) {
            index = -1;
            for(int j = 0; j < getReferenceTable().length; j++) {
                if (plaintextToChar[i] == getReferenceTable()[j]) {
                    index = j;
                    break;
                }
            }
            if (index >= 0) {
                encodedText+= offsetTable[index];
            } else {
                encodedText+=plaintextToChar[i];
            }
        }
        return encodedText;
    }

    private void populateOffsetTable() {
        int idx = findOffsetIndex(offsetValue);
        char[] offsetArray = new char[getReferenceTable().length];
        for(int i = 0; i < idx; i++) {
            offsetArray[i] = getReferenceTable()[(getReferenceTable().length - idx)+i];
        }
        for(int i = idx; i < getReferenceTable().length; i++) {
            offsetArray[i] = getReferenceTable()[i-idx];
        }

        offsetTable = offsetArray;
    }

    public String getEncodedText() {
        return encodedText;
    }

    public void setEncodedText(String encodedText) {
        this.encodedText = encodedText;
    }

    public char getOffsetValue() {
        return offsetValue;
    }

    public void setOffsetValue(char offsetValue) {
        this.offsetValue = offsetValue;
        populateOffsetTable();
    }

    public char[] getOffsetTable() {
        return offsetTable;
    }

    public void setOffsetTable(char[] offsetTable) {
        this.offsetTable = offsetTable;
    }

}
