package lesson2.Homework2;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arr[i][j] = String.valueOf(i + j);
            }
        }

        try {
            int sum = sizeSumArr(arr);
            System.out.println(sum);
            arr[0][1] = "&";
            sizeSumArr(arr);

        } catch (MyArraySizeException myArraySizeException) {
            myArraySizeException.printStackTrace();
        } catch (MyArrayDataException myArrayDataException) {
            myArrayDataException.printStackTrace();
        }
    }

    public static int sizeSumArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        if (arr.length !=4) {
            throw new MyArraySizeException();
        }  else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length != 4) {
                    throw new MyArraySizeException();
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}
