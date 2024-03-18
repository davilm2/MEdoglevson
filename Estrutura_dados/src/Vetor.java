public class Vetor {
    private Aluno[] alunos = new Aluno[100];

    private int totalDealunos = 0;

    public void Adiciona(Aluno aluno) {
        this.alunos[this.totalDealunos] = aluno;
        this.totalDealunos++;
    }

    public int getTotalDealunos() {
        return totalDealunos;
    }

    private boolean posicaoValida(int posicao) {
        return posicao >= 0 && posicao <= this.totalDealunos;
    }

    public void adicionaPosicao(int posicao, Aluno aluno) {
        if (posicao >= 0 && posicao <= totalDealunos) {
            for (int i = totalDealunos; i > posicao; i--) {
                alunos[i] = alunos[i - 1];
            }
            alunos[posicao] = aluno;
            totalDealunos++;
        }else{
            System.out.println("Posição inválida para adição");

        }
    }

    public void remove(int posicao) {
        if (!this.posicaoOcupada(posicao)) {
            throw new IllegalArgumentException("Posição inválida");
        }
        for (int i = posicao; i < this.totalDealunos - 1; i++) {
            this.alunos[i] = this.alunos[i + 1];
        }
        this.totalDealunos--;
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao < this.alunos.length && posicao >= 0;
    }



    public boolean contem (Aluno aluno){
            for (int i = 0; i < alunos.length; i++) {
                if (aluno == alunos[i]) {
                    return true;
                }
            }
            return false;
        }

        public int tamanho () {
            return this.totalDealunos;
        }

        public String toString () {
            if (this.totalDealunos == 0) {
                return "[]";
            }

            StringBuilder builder = new StringBuilder();
            builder.append("[");
            for (int i = 0; i < this.totalDealunos - 1; i++) {
                builder.append(this.alunos[i]);
                builder.append(", ");
            }
            builder.append(this.alunos[this.totalDealunos - 1]);
            builder.append("]");

            return builder.toString();
        }

        public Aluno pega ( int posicao){
            if (!this.posicaoOcupada(posicao)) {
                throw new IllegalArgumentException("Posicão inválida");
            }
            return this.alunos[posicao];
        }

    }

