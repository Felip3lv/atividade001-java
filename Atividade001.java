public class Atividade001 {

    public static void main(String[] args) {
        // Verifica se algum argumento foi passado
        if (args.length == 0) {
            System.out.println("Uso: java Atividade001 \"seu texto aqui\"");
            return;
        }

        // Junta todos os argumentos em um único texto
        String texto = String.join(" ", args);

        // ── 1. Contagem de palavras ──────────────────────────────────────
        String[] palavras = texto.trim().split("\\s+");
        int totalPalavras = palavras.length;

        // ── 2. Contagem de vogais (sem acentos) ──────────────────────────
        String textoNormalizado = texto.toLowerCase()
                .replaceAll("[áàãâä]", "a")
                .replaceAll("[éèêë]", "e")
                .replaceAll("[íìîï]", "i")
                .replaceAll("[óòõôö]", "o")
                .replaceAll("[úùûü]", "u");

        int totalVogais = 0;
        for (char c : textoNormalizado.toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) {
                totalVogais++;
            }
        }

        // ── 3. Estatística de palavras com letras pares e ímpares ────────
        int palavrasImpares = 0;
        int palavrasPares   = 0;

        for (String palavra : palavras) {
            // Remove caracteres não-letras para contar só as letras
            String apenasLetras = palavra.replaceAll("[^a-zA-ZÀ-ú]", "");
            if (apenasLetras.isEmpty()) continue;

            if (apenasLetras.length() % 2 == 0) {
                palavrasPares++;
            } else {
                palavrasImpares++;
            }
        }

        // ── Exibe os resultados ──────────────────────────────────────────
        System.out.println("=== Análise do Texto ===");
        System.out.println("Texto: " + texto);
        System.out.println("------------------------");
        System.out.println("Total de palavras : " + totalPalavras);
        System.out.println("Total de vogais   : " + totalVogais);
        System.out.println("------------------------");
        System.out.println("Palavras com nº de letras ÍMPAR : " + palavrasImpares);
        System.out.println("Palavras com nº de letras PAR   : " + palavrasPares);
    }
}