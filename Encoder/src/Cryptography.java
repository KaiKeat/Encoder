public class Cryptography {
    private final char[] referenceTable =
            {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                    '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                    '(', ')', '*', '+', ',', '-', '.', '/'};

    public Cryptography() {}

    public int findOffsetIndex(char offsetValue) {
        for (int i=0; i < referenceTable.length; i++) {
            if (offsetValue == referenceTable[i]) {
                return i;
            }
        }
        return 0;
    }

    public char[] getReferenceTable() {
        return referenceTable;
    }

}
