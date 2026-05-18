public class PasswordChecker {
    private int minLength;
    private int maxRepeats;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Минимальная длинна пароля не может быть отрицательной.");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторений символов подряд должно быть положительным числом.");
        }
        this.maxRepeats = maxRepeats;
    }

    boolean verify(String password) {
        if (this.minLength == -1 && this.maxRepeats == -1) {
            throw new IllegalStateException("Не все настройки пароля выставлены!");
        }
        if (password.length() < minLength) {
            return false;
        }
        int count = 0;
        char previousLatter = password.charAt(0);
        for (char latter : password.toCharArray()) {
            if (latter == previousLatter) {
                count++;
            } else {
                count = 1;
            }

            if (count > maxRepeats) {
                return false;
            }

            previousLatter = latter;
        }

        return true;
    }

}
