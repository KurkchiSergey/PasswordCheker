public class PasswordChecker {
    private int minLength = -1;
    private int maxRepeats = -1;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("введите положительное число для установки минимальной длинный пароля");
        } else {
            this.minLength = minLength;
        }

    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 1) {
            throw new IllegalArgumentException("введите максимальное не отрицательное количество повторений отличных от 0");
        } else {
            this.maxRepeats = maxRepeats;
        }
    }

    public boolean verify(String password) {
        if (minLength == -1 || maxRepeats == -1) {
            throw new IllegalStateException("Нужно выставить настройки чекеру");

        }
        if (password.length() < minLength) {
            return false;
        }
        int repeats = 1;
        for (int i = 1; i < password.length(); i++) {
            char cur = password.charAt(i);
            char prev = password.charAt(i - 1);
            if (cur == prev) {
                repeats++;
                if (repeats > maxRepeats) {
                    return false;
                }

            } else {
                repeats = 1;

            }

        }
        return true;
    }

}
