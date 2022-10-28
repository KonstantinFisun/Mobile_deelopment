// Точка входа в программу

public class Game {
    private int score; //Сумма всех чисел на поле
    private int size; // Размер поля
    private boolean endOfGame; //Флаг для завершения основного цикла программы
    private boolean is2048; //Хранит информацию о том, удалось ли игроку создать плитку 2048 (флаг победы)
    private Direction direction; //Направление, в котором требуется сдвиг клеток поля.
    private Draw draw; // Графика

    private Key keyListener; // Слушатель клавиатуры
    private Board board; // Игровое поле

    private boolean firstGeneration;
    public Game() {
        // Запуск игры
        initBoard(); // Создание поля
        createInitialCells(); // Генерация первых клеток


        while (!endOfGame) {

            input(); // Считываем клавишу
            logic(); // Логика

        }
        draw.dispose();
        System.out.println("Ваш результат = " + score);
        System.exit(-1);


    }

    public void print_board(){
        board.print_board();
    }

    // Задаём значения полей для начала игры
    private void initBoard() {
        size = 4; // Размер поля
        score = 0; // Счет
        endOfGame = false; // Флаг завершения
        is2048 = false; // Достигли 2048
        direction = Direction.AWAITING; // Направление сдвига
        draw = new Draw(size); // Графика
        keyListener = new Key(); //  Слушатель
        board = new Board(size); // Игровое поле
        draw.addKeyListener(keyListener);

    }

    // Создаём на поле начальные ячейки
    private void createInitialCells() {
        firstGeneration = true;
        for (int i = 0; i < size / 2; i++) {
            generateNewCell();
        }
        draw.draw_cell(board); // Отрисовка поля
    }

    // Генерация случайной клетки на поле
    private void generateNewCell() {
        //Проверяем, что есть свободные места
        if (!board.check_empty_cell() && !firstGeneration) {
            System.err.println("Невозможно генерация случайной клетки.");
            System.exit(-1);
        }
        firstGeneration = false;
        int num; // Новая клетка
        // Цикл пока не найдем свободную клетку
        while (true) {
            // Выбираем случайное положение
            int randomX = (int) (Math.random() * size);
            int randomY = (int) (Math.random() * size);

            // Если клетка свободна, то ок
            if (board.getState(randomX, randomY) == 0) {
                num = board.generate_random_number_cell(); // Генерация нового числа
                board.setState(randomX, randomY, num);
                break;
            }
        }

        score += num; // Обновляем счет
    }

    /**
     * Считывает пользовательский ввод.
     * Изменяет Main.direction и endOfGame;
     */
    private void input() {
        //keyListener.update();

        // Определяем направление, в котором нужно будет произвести сдвиг
        direction = keyListener.lastDirectionKeyPressed();

        //System.out.println(direction);
        System.out.println(direction);
        // Проверка что поле пустое
        if (!board.check_empty_cell() && direction != null){
            endOfGame = true;
        }

        // Окончание игры
        endOfGame = endOfGame || keyListener.wasEscPressed();
    }

    /**
     * Основная логика игры.
     * Если пользователь определил направление, вызывает метод сдвига.
     * Если сдвиг удался, создаёт новую плитку.
     */
    private void logic() {
        if (direction != Direction.AWAITING && direction != null) {
            //System.out.println(direction);
            if (shift(direction)) generateNewCell();

            draw.draw_cell(board); // Отрисовка поля
            //board.print_board();
            keyListener.lastDirectionKeyPressedSet(Direction.AWAITING);
            direction = Direction.AWAITING;
        }
    }

    /**
     * Результат работы метода сдвига shiftRow().
     * Содержит изменённую строку и информацию о том, эквивалентна ли она начальной.
     */
    private static class ShiftRowResult {
        boolean didAnythingMove; // Эквивалентна ли она начальной
        int[] shiftedRow; // Измененная строка
    }

    /**
     * Изменяет board, сдвигая все ячейки в указанном направлении,
     * вызывая shiftRow() для каждой строки/столбца (в зависимости от направления)
     *
     * @param direction Направление, в котором необходимо совершить сдвиг
     * @return Возвращает true, если сдвиг прошёл успешно (поле изменилось)
     */
    private boolean shift(Direction direction) {
        boolean ret = false;
        switch (direction) {
            case DOWN:
            case UP:

                // По очереди сдвигаем числа всех столбцов в нужном направлении
                for (int i = 0; i < size; i++) {
                    // Запрашиваем очередной столбец
                    int[] arg = board.getColumn(i);

                    // В зависимости от направления сдвига, меняем или не меняем порядок чисел на противоположный
                    if (direction == Direction.UP) {
                        int[] tmp = new int[arg.length];
                        for (int e = 0; e < tmp.length; e++) {
                            tmp[e] = arg[tmp.length - e - 1];
                        }
                        arg = tmp;
                    }

                    // Пытаемся сдвинуть числа в этом столбце
                    ShiftRowResult result = shiftRow(arg);

                    // Возвращаем линию в исходный порядок*
                    if (direction == Direction.UP) {
                        int[] tmp = new int[result.shiftedRow.length];
                        for (int e = 0; e < tmp.length; e++) {
                            tmp[e] = result.shiftedRow[tmp.length - e - 1];
                        }
                        result.shiftedRow = tmp;
                    }

                    // Записываем изменённый столбец
                    board.setColumn(i, result.shiftedRow);

                    //Если хоть одна линия была изменена, значит было изменено всё поле
                    ret = ret || result.didAnythingMove;
                }
                break;
            case RIGHT:

            case LEFT:

                // По очереди сдвигаем числа всех строк в нужном направлении
                for (int i = 0; i < size; i++) {
                    // Запрашиваем очередную строку
                    int[] arg = board.getLine(i);

                    // В зависимости от направления сдвига, меняем или не меняем порядок чисел на противоположный
                    if (direction == Direction.RIGHT) {
                        int[] tmp = new int[arg.length];
                        for (int e = 0; e < tmp.length; e++) {
                            tmp[e] = arg[tmp.length - e - 1];
                        }
                        arg = tmp;
                    }

                    // Пытаемся сдвинуть числа в этом столбце
                    ShiftRowResult result = shiftRow(arg);

                    // Возвращаем линию в исходный порядок
                    if (direction == Direction.RIGHT) {
                        int[] tmp = new int[result.shiftedRow.length];
                        for (int e = 0; e < tmp.length; e++) {
                            tmp[e] = result.shiftedRow[tmp.length - e - 1];
                        }
                        result.shiftedRow = tmp;
                    }

                    // Записываем изменённую строку
                    board.setLine(i, result.shiftedRow);

                    /*Если хоть одна линия была изменена, значит было изменено всё поле*/
                    ret = ret || result.didAnythingMove;
                }

                break;
            default:
                System.err.println("Невозможно сдвинуть клетки. Возможно неверные параметры.");
                System.exit(-2);
                break;
        }

        return ret;
    }

    private ShiftRowResult shiftRow(int[] oldRow) {
        ShiftRowResult ret = new ShiftRowResult();

        // Выкидываем все нули
        int[] oldRowWithoutZeroes = new int[oldRow.length];

        int q = 0; // Счетчик количества занятых клетов в строке

        for (int i = 0; i < oldRow.length; i++) {
            if (oldRow[i] != 0) {
                if (q != i) {
                    /*
                     * Это значит, что мы передвинули ячейку
                     * на место какого-то нуля (пустой плитки)
                     */
                    ret.didAnythingMove = true;
                }

                oldRowWithoutZeroes[q] = oldRow[i];
                q++;
            }
        }


        /*
        Если с ним можно совместить следующее за ним число (наш указатель +1), то переписываем в новый массив лишь их сумму,
        затем ставим указатель на третье число (второго уже нет).
        Иначе переписываем только первое, и ставим указатель на второе число.
         */

        // Массив с изменненной строкой
        ret.shiftedRow = new int[oldRowWithoutZeroes.length];


        q = 0;
        int i = 0;
        // Идем пока есть числа
        while (i < oldRowWithoutZeroes.length) {
            //Если следующие число совпадает
            if ((i + 1 < oldRowWithoutZeroes.length) && (oldRowWithoutZeroes[i] == oldRowWithoutZeroes[i + 1])
                    && oldRowWithoutZeroes[i] != 0) {
                ret.didAnythingMove = true; // Фиксируем что было изменение
                ret.shiftedRow[q] = oldRowWithoutZeroes[i] * 2; // Присваиваем число в два раза больше
                if(ret.shiftedRow[q] == 2048){
                    is2048 = true;
                }
                i++; // Следующие число не смотрим
            } else {
                ret.shiftedRow[q] = oldRowWithoutZeroes[i];
            }

            q++;
            i++;
        }

        return ret;
    }
}


