package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0)
            return new int[0];
        int buf = inputArray[inputArray.length - 1];
        for (int i = inputArray.length - 2; i >= 0; i--) {
            inputArray[i + 1] = inputArray[i];
        }
        inputArray[0] = buf;
        return inputArray;
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0)
            return 0;
        if (inputArray.length == 1)
            return inputArray[0];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length - 1; i++) {
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i] * inputArray[j] > max)
                    max = inputArray[i] * inputArray[j];
            }
        }
        return max;
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if (input == null)
            return 0;
        int charCount = 0;
        String inputLowerCase = input.toLowerCase();
        for (int i = 0; i < inputLowerCase.length(); i++) {
            if (inputLowerCase.charAt(i) == 'a' || inputLowerCase.charAt(i) == 'b') {
                charCount++;
            }
        }
        return (int)(charCount * 100 / (double)inputLowerCase.length());
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null)
            return false;
        if (input.length() <= 1)
            return true;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i))
                return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if (input == null || input.length() == 0)
            return "";
        StringBuilder result = new StringBuilder();
        int currentIndex = 0;
        char currentChar = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (currentChar != input.charAt(i)) {
                result.append(currentChar).append(i - currentIndex);
                currentChar = input.charAt(i);
                currentIndex = i;
            }
        }
        result.append(currentChar).append(input.length() - currentIndex);
        return result.toString();
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if (one == null || two == null || one.length() == 0 || one.length() != two.length())
            return false;
        StringBuilder oneBuilder = new StringBuilder(one);
        for (int i = 0; i < two.length(); i++) {
            int charIndex = oneBuilder.toString().indexOf(two.charAt(i));
            if (charIndex >= 0) {
                oneBuilder.delete(charIndex, charIndex + 1);
            }
            else return false;
        }
        return true;
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if (s == null || s.equals(""))
            return false;
        char[] uniqueChars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (charArrayContainsOrAdd(uniqueChars, s.charAt(i)))
                return false;
        }
        return true;
    }

    static boolean charArrayContainsOrAdd(char[] array, char characterToFind) {
        boolean contains = false;
        for (char c : array) {
            if (c == characterToFind) {
                contains = true;
                break;
            }
        }
        if (contains) {
            return true;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0)
                array[i] = characterToFind;
        }
        return false;
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null)
            return new int[][] {{},{}};
        if (m.length == 0 || m.length != m[0].length)
            return m;
        int[][] result = new int[m[0].length][m.length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result[j][i] = m[i][j];
            }
        }
        return result;
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if (separator == null)
            separator = ' ';
        if (inputStrings == null || inputStrings.length == 0)
            return "";
        StringBuilder result = new StringBuilder(inputStrings[0]);
        for (int i = 1; i < inputStrings.length; i++) {
            result.append(separator).append(inputStrings[i]);
        }
        return result.toString();
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if (inputStrings == null || prefix == null)
            return 0;
        int count = 0;
        for (String string : inputStrings) {
            if (string.startsWith(prefix))
                count++;
        }
        return count;
    }
}
