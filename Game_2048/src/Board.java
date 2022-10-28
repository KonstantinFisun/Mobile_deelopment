public class Board {
    /**
     * Состояние всех ячеек поля.
     */
    private final int[][] board;
    private final int size;


    // Инициализирует поле и заполняет его нулями
    public Board(int size){
        this.size = size;
        board = new int[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                board[i][j] = 0;
            }
        }
    }

    // Возвращает состояние ячейки поля по координатам
    public int getState(int x, int y){
        return board[x][y];
    }

    // Изменяет состояние ячейки поля по координатам
    public void setState(int x, int y, int state){
        board[x][y] = state;
    }

    // Изменяет столбец под номером i
    public void setColumn(int i, int[] newColumn) {
        for(int j = 0; j < size; j++){
            board[j][i] = newColumn[j];
        }
    }

    // Возвращает массив состояний ячеек столбца под номером i
    public int[] getColumn(int i) {
        int[] res = new int[size];

        for(int j = 0; j < size; j++){
            res[j] = board[j][i];
        }

        return res;
    }

    // Изменяет строку под номером i
    public void setLine(int i, int[] newLine) {
        for(int j = 0; j < size; j++){
            board[i][j] = newLine[j];
        }
    }

    // Возвращает массив состояний ячеек строки под номером i
    public int[] getLine(int i) {
        int[] res = new int[size];

        for(int j = 0; j < size; j++){
            res[j] = board[i][j];
        }

        return res;
    }

    // Генерация нового числа
    public int generate_random_number_cell(){
        // Шанс выпадения цифры 4 : 1 к 4
        int number = (int) (Math.random() * 4);
        if (number == 3) {
            return 4;
        } else {
            return 2;
        }
    }

    // Проверка, что есть свободные клетки
    public boolean check_empty_cell(){
        for(int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(board[i][j] != 0) return true;
            }
        }
        return false;
    }

    // Вывод поля
    public void print_board(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}
