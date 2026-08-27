class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean digitAfterE = true;
        boolean eSeen = false;
        boolean dotSeen = false;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Digit
            if (c >= '0' && c <= '9') {

                digitSeen = true;

                if (eSeen) {
                    digitAfterE = true;
                }
            }

            // + or -
            else if (c == '+' || c == '-') {

                // Sign is allowed only:
                // 1. at the beginning
                // 2. immediately after e/E
                if (i != 0 &&
                    s.charAt(i - 1) != 'e' &&
                    s.charAt(i - 1) != 'E') {

                    return false;
                }
            }

            // Decimal point
            else if (c == '.') {

                // Only one decimal
                // Decimal cannot appear after e/E
                if (dotSeen || eSeen) {
                    return false;
                }

                dotSeen = true;
            }

            // e or E
            else if (c == 'e' || c == 'E') {

                // Only one exponent
                if (eSeen) {
                    return false;
                }

                // Must have a digit before exponent
                if (!digitSeen) {
                    return false;
                }

                eSeen = true;
                digitAfterE = false;
            }

            // Invalid character
            else {
                return false;
            }
        }

        return digitSeen && digitAfterE;
    }
}