package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculate {

    private Map<String, List<Double>> notasPorAluno = new HashMap<>();

    public Calculate() {
    }

    public void addNotas(String nomeAluno, List<Double> notas) {
        notasPorAluno.put(nomeAluno, notas);
    }

    public Double mediaNotaAluno(String nomeAluno) {
        List<Double> notas = notasPorAluno.get(nomeAluno);

        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }

        double soma = 0;
        for (Double nota : notas) {
            soma += nota;
        }

        return soma / notas.size();
    }

    public List<String> getNomesAlunos() {
        return new ArrayList<>(notasPorAluno.keySet());
    }
}
