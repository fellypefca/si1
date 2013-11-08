package lab1;

public class Invalid extends Exception {
        private static final long serialVersionUID = 1L;

        @Override
        public String getMessage() {
                return "Valor inválido, Digite novamente: ";
        }
}