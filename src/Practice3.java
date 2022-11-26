public class Practice3 {
    public static void main(String[] args) {
        //Количесво корней уравнения
        System.out.println(solutions(1, 0, -1));
        System.out.println(solutions(1, 0, 0));
        System.out.println(solutions(1, 0, 1));
        System.out.println("----------------------");

        //Находит индекс второго вхождения "zip"
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(findZip("all zip files are compressed"));
        System.out.println("----------------------");

        //Функция, которая проверяет, является ли целое число совершенным числом или нет
        System.out.println(checkPerfect(6));
        System.out.println(checkPerfect(28));
        System.out.println(checkPerfect(496));
        System.out.println(checkPerfect(12));
        System.out.println(checkPerfect(97));
        System.out.println("----------------------");

        //Функция, которая принимает строку и возвращает новую строку с заменой ее первого и последнего символов, за исключением трех условий
        System.out.println(flipEndChars("Cat, dog, and mouse."));
        System.out.println(flipEndChars("ada"));
        System.out.println(flipEndChars("Ada"));
        System.out.println(flipEndChars("z"));
        System.out.println("----------------------");

        //Функция, которая определяет, является ли строка допустимым шестнадцатеричным кодом
        System.out.println(isValidHexCode("#CD5C5C"));
        System.out.println(isValidHexCode("#EAECEE"));
        System.out.println(isValidHexCode("#eaecee"));
        System.out.println(isValidHexCode("#CD5C58C"));
        System.out.println(isValidHexCode("#CD5C5Z"));
        System.out.println(isValidHexCode("#CD5C&C"));
        System.out.println(isValidHexCode("CD5C5C"));
        System.out.println("----------------------");

        //Функция, которая возвращает true, если два массива имеют одинаковое количество уникальных элементов, и false в противном случае
        System.out.println(same(new int [] {1, 3, 4, 4, 4}, new int [] {2, 5, 7}));
        System.out.println(same(new int [] {9, 8, 7, 6}, new int [] {4, 4, 3, 1}));
        System.out.println(same(new int [] {2}, new int [] {3, 3, 3, 3, 3}));
        System.out.println("----------------------");

        //Функция, которая возвращает true, если это число Капрекара, и false, если это не так
        System.out.println(isKaprekar(3));
        System.out.println(isKaprekar(5));
        System.out.println(isKaprekar(297));
        System.out.println("----------------------");

        //Функция, которая возвращает самую длинную последовательность последовательных нулей в двоичной строке
        System.out.println(longestZero("01100001011000"));
        System.out.println(longestZero("100100100"));
        System.out.println(longestZero("11111"));
        System.out.println("----------------------");

        //Функция, которая возвращает следующее простое число. Если число простое, верните само число
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(24));
        System.out.println(nextPrime(11));
        System.out.println("----------------------");

        //Функция. учитывая три числа, x, y и z, определяет, являются ли они ребрами прямоугольного треугольника
        System.out.println(rightTriangle(3, 4, 5));
        System.out.println(rightTriangle(145, 105, 100));
        System.out.println(rightTriangle(70, 130, 110));
    }
    public static int solutions(int a, int b, int c){
        //Находим дискриминант, если дискриминант больше нуля, то корней два, если меньше нуля, то корней нет, если равен нулю, то корень один
        int D = b * b - 4 * a * c;
        if (D < 0) return 0;
        if (D == 0) return 1;
        else return 2;
    }
    public static int findZip(String s){
        //Находим индекс второго "zip"-а, задав начальный поиск индекс первого вхождения + 1
        return s.indexOf("zip",s.indexOf("zip")+1);
    }
    public static boolean checkPerfect(int number){
        //Объявляем переменную, которая будет складывать в себя множители числа, а дальше сравниваем получившее с исходным числом
        int total = 0;
        for (int i = 1; i < number; i++){
            if (number % i == 0){
                total += i;
            }
        }
        return total == number;
    }
    public static String flipEndChars(String s){
        //С помощью конкатенации возращаем строку, если два условия не соблюдаются
        int lastIndex = s.length() - 1;
        if (s.length() < 2) return "Incompatible.";
        if (s.charAt(0) == s.charAt(lastIndex)) return "Two's a pair.";
        return s.charAt(lastIndex) + s.substring(1, lastIndex) + s.charAt(0);
    }
    public static boolean isValidHexCode(String code){
        String charsNumbers = "0123456789ABCDEFabcdef";
        int count = 0;
        if (code.length() == 7 && code.startsWith("#")){
            for (int i = 1; i < code.length();  i++){
                if (charsNumbers.contains("" + code.charAt(i))){
                    count += 1;
                }
            }
        }
        return count == 6;
    }
    public static boolean same(int[] arr1, int[] arr2){
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i < arr1.length - 1; i++){
            if (arr1[i] == arr1[i+1]) counter1 += 1;
        }
        for (int j = 0; j < arr2.length - 1; j++){
            if (arr2[j] == arr2[j+1]) counter2 += 1;
        }
        return arr1.length - counter1 == arr2.length - counter2;
    }
    public static boolean isKaprekar(int num){
        int nSquare = num * num;
        int length = Integer.toString(nSquare).length();
        int result = 0;
        if (length == 1) return nSquare == num;
        else{
            int left = (int) (nSquare / Math.pow(10, (length + 1) / 2));
            int right = (int) (nSquare % Math.pow(10, (length + 1) / 2));
            result = left + right;
        }
        return result == num;
    }
    public static String longestZero(String s){
        //Находим максимальное количество повторений нулю, а затем повторяем "0" на максимальное кол-во повторений
        int max = 0;
        int counter = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '0') counter += 1;
            else counter = 0;
            if (counter > max) max = counter;
        }
        return "0".repeat(max);
    }
    public static int nextPrime(int n){
        //Если число меньше 2, то сразу присваиваем следующее простое число двум
        if (n < 2) n = 2;
        //Проверяем число на простоту, если оно простое возврщаем само число, если нет добавляем к нему единицу, пока не найдётся следующее простое число
        for (int i = 2; i < n/2+1; i ++){
            if (n % i == 0){
                n += 1;
                i = 2;
            }
        }
        return n;
    }
    public static boolean rightTriangle(int x, int y, int z){
        //Используя формулу Пифагора будем проверять треугольник
        int maxNum = Math.max(Math.max(x, y), z);
        int avNum = Math.min(Math.max(x, y), Math.max(y, z));
        int minNum = Math.min(Math.min(x, y), z);
        return Math.pow(maxNum, 2) == Math.pow(avNum, 2) + Math.pow(minNum, 2);
    }
}