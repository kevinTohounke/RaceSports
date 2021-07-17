package racesports;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RaceSports {

    public static int aux = 0;
    public static ArrayList<String> leituraFile = new ArrayList<>();

    static void quebraDeLinha() {
        if (aux < leituraFile.size()) {
            aux++;
        } else {
            System.out.println("Fim File");
        }
    }

    static String getLinha() {

        String s = leituraFile.get(aux);
        //quebraDeLinha(aux,ficheiro);
        return s;
    }

    public static void main(String[] args) {

        String fileNome, fileNome2;
        ArrayList<Campeonato> arrayListDeCampeonato = new ArrayList<>();
        Campeonato campeonatoSaida;
        int indexCampeonato = 1;
        int whileControlerCampeonato = 1;
        Campeonato[] vectCampeonato = null;
        Campeonato c2 = new Campeonato();
        Corrida cEntrada;
        int yiu = 0, iu = 0, rep = 0;
        int aux = 0;
        int numeroDeCorridaEntrada = 0;
        char cc;
        char cc2;
        Piloto pilotoEntrada = null;
        Piloto pilE = null;
        String testeSCE;
        int[] sistemaClassificacaoEntrada;
        int tamanho, dior = 0;
        String[] arrayStrings;
        String htr;
        int switchControl;
        int valor;
        String[] vectNomePilotoCorrida = new String[2];

        String lerLinhaSce = null;
        Corrida[] corridaEntrada;
        String lerPiloto;
        String[] vectNomePiloto = new String[2];
        String[] vectNomeCampeonato;
        vectNomeCampeonato = new String[2];
        String linha;
        int numeroPilotosEntrada = 0;

        Scanner in = new Scanner(System.in);
        String fileName, fileName2;
        fileName = "Input.txt";

        int numeroDeCorridaDoCamp = 0;
        int numeroDePilotoDoCamp = 0;
        char d1, d2;

        //Variaveis do Ficheiro de Saida
        int qtdDePontoSP;
        int numeroDeCampeonato = 0;
        int controlCampeonato = 0;
        Campeonato newCamp = null;
        String[] vectNomePilotoSplit;
        Piloto newPilotoNewCamp;
        int[] vectSPnewCamp;
        String[] vectSplitSP;
        int po = 0, jos = 0;
        int qtdDePilotoDoCamp = 0;
        Corrida corridaNewCamp = null;
          ArrayList<Campeonato> listaCampFile = new ArrayList<Campeonato>();

        String[] vectSplitNomeCamp = new String[2];
        int numeroDeCorridaNewCamp = 0;

        BufferedWriter bf2 = null;
        BufferedWriter bf = null;
        Corrida corrida;
        Equipa equipa;
        Equipa equipaAux = new Equipa();
        Piloto pilotoAux = new Piloto();
        Piloto pilotoAux2 = new Piloto();
        int counterPil = 1;
        int counterLinhas = 1;
        int n = 1, k = 1, x = 0, c = 0, p = 1, t = 1, skp = 1, h = 1;
        Date nomeVariavel = new Date();
        SimpleDateFormat nv = new SimpleDateFormat("YYYYMMDDhhmmss");
        String outputFormat = nv.format(nomeVariavel);

        fileName = "Input.txt";
        fileName2 = outputFormat + ".txt";

        BufferedReader bfr;

        String fileNameTORead, s;
        fileNameTORead = "Input.txt";

        String name, nomeClassificado;
        Campeonato campeonato;

        Piloto piloto1;
        Piloto pilotoCorrida;

        System.out.println("Qual Operação deseja Realizar? \n 1- Registar Campeonatos 2 - Ler Ficheiro ");
        switchControl = in.nextInt();
        in.nextLine();
        switch (switchControl) {
            case 1:
                // Registo de Campeonatos
                do {
                    campeonato = new Campeonato();
                    System.out.println("Digite o nome do " + indexCampeonato + "º campeonato ");
                    campeonato.nome = in.nextLine();
                    System.out.println("Digite o ano de Realização: do " + indexCampeonato + "º campeonato ");
                    campeonato.anoRealizacao = in.nextInt();
                    in.nextLine();
                    // ##REGISTO DOS PILOTOS
                    do {

                        piloto1 = new Piloto();

                        System.out.println("Digite o nome do: " + p + "º Piloto");
                        piloto1.nome = in.nextLine();

                        System.out.println("Digite a equipa do: " + p + "º Piloto");
                        piloto1.equipa = in.nextLine();
                        campeonato.pilotos.add(piloto1);

                        System.out.println(" DESEJA CONTINUAR A ADICIONAR PILOTOS ? \n 0 - Parar / 1 - Continuar ");
                        n = in.nextInt();
                        p++;
                        in.nextLine();
                    } while (n != 0);
                    p = 1;
                    // ####  REGISTO DO SISTEMA DE PONTUAÇÃO 
                    do {
                        int ponto;
                        System.out.println("Digite o " + skp + "º ponto do sistema de pontuação do Campeonato:");
                        ponto = in.nextInt();
                        campeonato.sistemaPontuacao.add(ponto);
                        System.out.println("DESEJA CONTINUAR A ADICIONAR PONTOS NO SISTEMA DE PONTUAÇÃO ? \n 0 - Parar / 1 - Continuar ");
                        k = in.nextInt();
                        skp++;
                        in.nextLine();
                    } while (k != 0);
                    skp = 1;
                    // ### REGISTO DO RESULTADO DAS CORRIDAS
                    do {
                        // Instanciando uma corrida 
                        corrida = new Corrida();
                        System.out.println("Digite o nome da: " + h + "º Corrida");
                        name = in.nextLine();
                        corrida.nome = name;
                        // Copiando pilotos de Campeonato na Corrida
                        for (int qwert = 0; qwert < campeonato.pilotos.size(); qwert++) {
                            pilotoCorrida = new Piloto();
                            pilotoCorrida.nome = campeonato.pilotos.get(qwert).nome;
                            pilotoCorrida.equipa = campeonato.pilotos.get(qwert).equipa;
                            corrida.pilotos.add(pilotoCorrida);
                        }

                        t = 1;
                        //Atribuindo Pontos aos pilotos da corrida e do Campeonato 
                        for (int w = 0; w < campeonato.sistemaPontuacao.size(); w++) {
                            System.out.println("Digite o nome do " + t + "º classificado:");
                            nomeClassificado = in.nextLine();
                            for (int r = 0; r < corrida.pilotos.size(); r++) {
                                if (corrida.pilotos.get(r).nome.trim().equalsIgnoreCase(nomeClassificado)) {
                                    corrida.pilotos.get(r).ponto = campeonato.sistemaPontuacao.get(w);
                                    campeonato.pilotos.get(r).ponto += campeonato.sistemaPontuacao.get(w);
                                    if (t == 1) {
                                        corrida.pilotos.get(r).desempate += 3;
                                    }
                                    if (t == 2) {
                                        corrida.pilotos.get(r).desempate += 2;
                                    }
                                    if (t == 1) {
                                        corrida.pilotos.get(r).desempate += 1;
                                    }
                                }
                            }
                            if (w >= campeonato.sistemaPontuacao.size()) {
                                System.out.println("Piloto Invalido");

                            } else {
                                t++;
                            }
                        }
                        campeonato.corridas.add(corrida);
                        System.out.println(" DESEJA CONTINUAR A ADICIONAR CORRIDAS ? \n 0 - Parar / 1 - Continuar ");
                        c = in.nextInt();
                        h++;

                        in.nextLine();

                    } while (c != 0);
                    h = 1;

                    // ###Organizar os Pilotos do ArrayList  das Corridas do Campeonato em ordem Decrescente, do Melhor ao pior:
                    /*Corridas do Campeonato: */
                    for (int lop = 0; lop < campeonato.corridas.size(); lop++) {

                        /* Pilotos da corrida nº lop : */
                        for (int zx = 0; zx < campeonato.corridas.get(lop).pilotos.size(); zx++) {

                            for (int lit = zx + 1; lit < campeonato.corridas.get(lop).pilotos.size(); lit++) {

                                if ((campeonato.corridas.get(lop).pilotos.get(zx).ponto + campeonato.corridas.get(lop).pilotos.get(zx).desempate) < (campeonato.corridas.get(lop).pilotos.get(lit).ponto + campeonato.corridas.get(lop).pilotos.get(lit).desempate)) {

                                    pilotoAux.nome = campeonato.corridas.get(lop).pilotos.get(lit).nome;
                                    pilotoAux.equipa = campeonato.corridas.get(lop).pilotos.get(lit).equipa;
                                    pilotoAux.ponto = campeonato.corridas.get(lop).pilotos.get(lit).ponto;
                                    pilotoAux.desempate = campeonato.corridas.get(lop).pilotos.get(lit).desempate;

                                    campeonato.corridas.get(lop).pilotos.get(lit).nome = campeonato.corridas.get(lop).pilotos.get(zx).nome;
                                    campeonato.corridas.get(lop).pilotos.get(lit).equipa = campeonato.corridas.get(lop).pilotos.get(zx).equipa;
                                    campeonato.corridas.get(lop).pilotos.get(lit).ponto = campeonato.corridas.get(lop).pilotos.get(zx).ponto;
                                    campeonato.corridas.get(lop).pilotos.get(lit).desempate = campeonato.corridas.get(lop).pilotos.get(zx).desempate;

                                    campeonato.corridas.get(lop).pilotos.get(zx).nome = pilotoAux.nome;
                                    campeonato.corridas.get(lop).pilotos.get(zx).equipa = pilotoAux.equipa;
                                    campeonato.corridas.get(lop).pilotos.get(zx).ponto = pilotoAux.ponto;
                                    campeonato.corridas.get(lop).pilotos.get(zx).desempate = pilotoAux.desempate;

                                }

                            }

                        }
                    }
                    // Criar ArrayList de equipas com ArrayList de Corridas e não do Campeonato
                    //Criação do ArrayList de Equipas 
                    for (int ver = 0; ver < campeonato.pilotos.size(); ver++) {
                        equipa = new Equipa();
                        equipa.ponto = campeonato.pilotos.get(ver).ponto;
                        equipa.nome = campeonato.pilotos.get(ver).equipa;
                        campeonato.equipas.add(equipa);
                    }

                    // Remoção de Equipes com mesmo nome, se encontrar mais uma ocorrência apaga a segunda, mas mantém a primeira.
                    for (int ptre = 0; ptre < campeonato.equipas.size(); ptre++) {
                        for (int xsw = ptre + 1; xsw < campeonato.equipas.size(); xsw++) {
                            if (campeonato.equipas.get(ptre).nome.equalsIgnoreCase(campeonato.equipas.get(xsw).nome) && campeonato.equipas.get(ptre).ponto >= campeonato.equipas.get(xsw).ponto) {
                                campeonato.equipas.remove(xsw);
                            }
                        }

                    }
                    // Organização em  Ordem Decrescente do ArrayList de Pilotos do campeonato, do Melhor ao Pior:
                    for (int iop = 0; iop < campeonato.pilotos.size(); iop++) {

                        for (int opo = iop + 1; opo < campeonato.pilotos.size(); opo++) {

                            if (campeonato.pilotos.get(iop).ponto < campeonato.pilotos.get(opo).ponto) {
                                pilotoAux2.nome = campeonato.pilotos.get(iop).nome;
                                pilotoAux2.equipa = campeonato.pilotos.get(iop).equipa;
                                pilotoAux2.ponto = campeonato.pilotos.get(iop).ponto;
                                pilotoAux2.desempate = campeonato.pilotos.get(iop).desempate;

                                campeonato.pilotos.get(iop).nome = campeonato.pilotos.get(opo).nome;
                                campeonato.pilotos.get(iop).equipa = campeonato.pilotos.get(opo).equipa;
                                campeonato.pilotos.get(iop).ponto = campeonato.pilotos.get(opo).ponto;
                                campeonato.pilotos.get(iop).desempate = campeonato.pilotos.get(opo).desempate;

                                campeonato.pilotos.get(opo).nome = pilotoAux2.nome;
                                campeonato.pilotos.get(opo).equipa = pilotoAux2.equipa;
                                campeonato.pilotos.get(opo).ponto = pilotoAux2.ponto;
                                campeonato.pilotos.get(opo).desempate = pilotoAux2.desempate;

                            }
                        }

                    }
                    // Organização em Ordem Decrescente do ArrayList de Equipas, do Melhor ao Pior:
                    for (int nmn = 0; nmn < campeonato.equipas.size(); nmn++) {

                        for (int zxc = nmn + 1; zxc < campeonato.equipas.size(); zxc++) {
                            if (campeonato.equipas.get(nmn).ponto < campeonato.equipas.get(zxc).ponto) {

                                equipaAux.nome = campeonato.equipas.get(nmn).nome;
                                equipaAux.ponto = campeonato.equipas.get(nmn).ponto;

                                campeonato.equipas.get(nmn).nome = campeonato.equipas.get(zxc).nome;
                                campeonato.equipas.get(nmn).ponto = campeonato.equipas.get(zxc).ponto;

                                campeonato.equipas.get(zxc).nome = equipaAux.nome;
                                campeonato.equipas.get(zxc).ponto = equipaAux.ponto;

                            }
                        }

                    }

                    System.out.println(" DESEJA CONTINUAR A ADICIONAR CAMPEONATOS ? \n 0 - Parar / 1 - Continuar ");
                    whileControlerCampeonato = in.nextInt();
                    indexCampeonato++;
                    in.nextLine();
                    arrayListDeCampeonato.add(campeonato);
                } while (whileControlerCampeonato != 0);

                // ###  ESCRITA DOS VALORES DE ENTRADA  NUM FICHEIRO DE ENTRADA DE ACORDO AO ENUNCIADO
                try {
                    bf = new BufferedWriter(new FileWriter(fileName));

                    bf.write(Integer.toString(arrayListDeCampeonato.size()));

                    for (int contadorEscritaCampeonato = 0; contadorEscritaCampeonato < arrayListDeCampeonato.size(); contadorEscritaCampeonato++) {
                        bf.newLine();
                        bf.newLine();

                        //Nome do Campeonato, Ano de Realizaçao:
                        bf.write(arrayListDeCampeonato.get(contadorEscritaCampeonato).nome + ", " + arrayListDeCampeonato.get(contadorEscritaCampeonato).anoRealizacao);
                        //Linha em branco:
                        bf.newLine();
                        bf.newLine();
                        //Quantidade de Pilotos:
                        bf.write(Integer.toString(arrayListDeCampeonato.get(contadorEscritaCampeonato).pilotos.size()) + " ");
                        //Linha em branco:
                        bf.newLine();

                        //Pilotos e respectivas Equipas:
                        for (int i = 0; i < arrayListDeCampeonato.get(contadorEscritaCampeonato).pilotos.size(); i++) {
                            bf.write(arrayListDeCampeonato.get(contadorEscritaCampeonato).pilotos.get(i).nome + ", " + arrayListDeCampeonato.get(contadorEscritaCampeonato).pilotos.get(i).equipa);
                            bf.newLine();

                        }
                        //Linha em branco:
                        bf.newLine();
                        //Quantidade de Pontos do Sistema de Pontuação 'espaço' Pontos do sistema de pontuação:
                        bf.write(Integer.toString(arrayListDeCampeonato.get(contadorEscritaCampeonato).sistemaPontuacao.size()) + " ");
                        //Pontos do Sistema de Pontuação:
                        for (int fg = 0; fg < arrayListDeCampeonato.get(contadorEscritaCampeonato).sistemaPontuacao.size(); fg++) {
                            bf.write(Integer.toString(arrayListDeCampeonato.get(contadorEscritaCampeonato).sistemaPontuacao.get(fg)) + " ");

                        }

                        //Linha em branco:
                        bf.newLine();
                        bf.newLine();
                        // Número de corridas:
                        bf.write(Integer.toString(arrayListDeCampeonato.get(contadorEscritaCampeonato).corridas.size()));
                        bf.newLine();

                        //Print Resultado das respectivas corridas
                        for (int lop = 0; lop < arrayListDeCampeonato.get(contadorEscritaCampeonato).corridas.size(); lop++) {
                            bf.newLine();
                            bf.write(arrayListDeCampeonato.get(contadorEscritaCampeonato).corridas.get(lop).nome);
                            bf.newLine();
                            for (int zx = 0; zx < arrayListDeCampeonato.get(contadorEscritaCampeonato).corridas.get(lop).pilotos.size(); zx++) {
                                bf.write(arrayListDeCampeonato.get(contadorEscritaCampeonato).corridas.get(lop).pilotos.get(zx).nome + ", " + arrayListDeCampeonato.get(contadorEscritaCampeonato).corridas.get(lop).pilotos.get(zx).equipa);
                                bf.newLine();
                            }
                        }
                        //P
                    }
                    bf.close();

                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                // ### ESCRITA DOS RESULTADOS DO CAMPEONATO NUM FICHEIRO DE SAÍDA DE ACORDO AO ENUNCIADO

                try {

                    bf2 = new BufferedWriter(new FileWriter(fileName2));
                    for (int contadorEscritaCampeonatoOutput = 0; contadorEscritaCampeonatoOutput < arrayListDeCampeonato.size(); contadorEscritaCampeonatoOutput++) {
                        bf2.write(arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).nome + ", " + arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).anoRealizacao);

                        bf2.newLine();
                        bf2.newLine();

                        bf2.write("Classificação após " + arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).corridas.size() + " provas realizadas");
                        bf2.newLine();
                        bf2.newLine();
                        bf2.write("Pilotos");
                        bf2.newLine();
                        bf2.newLine();

                        // Escrita dos Pilotos:
                        for (int perty = 0; perty < arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).pilotos.size(); perty++) {
                            bf2.write(Integer.toString(counterPil) + ". " + arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).pilotos.get(perty).nome + ", " + arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).pilotos.get(perty).equipa + ", " + Integer.toString(arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).pilotos.get(perty).ponto) + " pontos");
                            bf2.newLine();
                            counterPil++;
                        }
                        counterPil = 1;
                        bf2.newLine();
                        bf2.newLine();
                        bf2.write("Equipas");
                        bf2.newLine();
                        bf2.newLine();
                        //Escrita das equipas
                        for (int equipCoun = 0; equipCoun < arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).equipas.size(); equipCoun++) {
                            bf2.write(Integer.toString(counterPil) + ". " + arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).equipas.get(equipCoun).nome + ", " + Integer.toString(arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).equipas.get(equipCoun).ponto) + " pontos");
                            bf2.newLine();
                            counterPil++;
                        }

                        bf2.newLine();
                    }
                    bf2.close();

                } catch (IOException ex) {
                    System.out.println(ex.getMessage());

                }

                break;

            case 2:
                System.out.println("Digite o nome do ficheiro: ");
                fileNome = in.nextLine();
                fileNome2 = fileNome + ".txt";

                //Leitura de um tipo de UM FICHEIRO: 
                try {
                    bfr = new BufferedReader(new FileReader(fileNome2));
                    s = bfr.readLine();
                    while (s != null) {
                        leituraFile.add(s);
                        s = bfr.readLine();

                    }

                    bfr.close();
                } catch (IOException loki) {

                    System.out.println(loki.getMessage());

                }

                // Escrevendo a saida partindo do file
              
                numeroDeCampeonato = Integer.parseInt(getLinha());
                
                for (int p2 = 0; p2 < numeroDeCampeonato; p2++) {
                    newCamp = new Campeonato();
                    quebraDeLinha();
                    quebraDeLinha();
                    vectSplitNomeCamp = getLinha().split(",");

                    newCamp.nome = vectSplitNomeCamp[0];

                    newCamp.anoRealizacao = Integer.parseInt(vectSplitNomeCamp[1].trim());
                    quebraDeLinha();
                    quebraDeLinha();

                    valor = Integer.parseInt(getLinha().trim());

                    numeroDePilotoDoCamp = valor;

                    qtdDePilotoDoCamp = valor;

                    while (numeroDePilotoDoCamp > 0) {

                        quebraDeLinha();
                        newPilotoNewCamp = new Piloto();

                        vectNomePilotoSplit = getLinha().split(",");
                        newPilotoNewCamp.nome = vectNomePilotoSplit[0];
                        newPilotoNewCamp.equipa = vectNomePilotoSplit[1];
                        newCamp.pilotos.add(newPilotoNewCamp);

                        numeroDePilotoDoCamp--;
                    }
                    quebraDeLinha();
                    quebraDeLinha();
                    vectSplitSP = getLinha().split(" ");

                    for (int lrt = 1; lrt < vectSplitSP.length; lrt++) {
                        newCamp.sistemaPontuacao.add(Integer.parseInt(vectSplitSP[lrt]));
                    }
                    quebraDeLinha();
                    quebraDeLinha();

                    numeroDeCorridaNewCamp = Integer.parseInt(String.valueOf(getLinha().charAt(0)));
                    //System.out.println("Numero de corridas do camp: " + numeroDeCorridaNewCamp);

                    while (numeroDeCorridaNewCamp > 0) {
                        quebraDeLinha();
                        quebraDeLinha();

                        corridaNewCamp = new Corrida();
                        corridaNewCamp.nome = getLinha();
                       // System.out.println("nome das corridas: "+ corridaNewCamp.nome );
                        while (qtdDePilotoDoCamp > 0) {
                            quebraDeLinha();
                            newPilotoNewCamp = new Piloto();
                            vectNomePilotoSplit = getLinha().split(",");
                            newPilotoNewCamp.nome = vectNomePilotoSplit[0];
                            newPilotoNewCamp.equipa = vectNomePilotoSplit[1];
                            //System.out.println( "Piloto (Nome+Equipa)"+newPilotoNewCamp.nome +", "+ newPilotoNewCamp.equipa);
                            if (jos < newCamp.sistemaPontuacao.size()) {
                                newPilotoNewCamp.ponto = newCamp.sistemaPontuacao.get(jos);
                                jos++;
                            }

                            corridaNewCamp.pilotos.add(newPilotoNewCamp);

                            qtdDePilotoDoCamp--;
                        }
                        newCamp.corridas.add(corridaNewCamp);
                        jos = 0;
                        qtdDePilotoDoCamp = valor;
                        numeroDeCorridaNewCamp--;
                    }
                    
                    listaCampFile.add(newCamp);
                    quebraDeLinha();
                }
                break;

        }
        System.out.println("Quantidade de Campeonatos:"+listaCampFile.size());
        
       
        System.out.println("Quantidade de Pilotos" + newCamp.pilotos.size());
        System.out.println("Numero de corridas: " + newCamp.corridas.size());
        
        for (int zx = 0; zx < listaCampFile.size(); zx++) {
             System.out.println("Nome do campeonato: " + listaCampFile.get(zx).nome+", "+"Ano de Realização : " +  listaCampFile.get(zx).anoRealizacao);
        
        for (int i = 0; i < 2; i++) {
            System.out.println("*******************************");
        }
        
        System.out.println("Sistema de Pontuação");
        for (int olp = 0; olp < listaCampFile.get(zx).sistemaPontuacao.size(); olp++) {
            System.out.println(olp+"ºPonto: "+ listaCampFile.get(zx).sistemaPontuacao.get(olp));
        }
        
        System.out.println(" #### Pilotos do Campeonato ###");
        for (int zxc = 0; zxc < listaCampFile.get(zx).pilotos.size(); zxc++) {
            System.out.println( listaCampFile.get(zx).pilotos.get(zxc).nome + ", " + listaCampFile.get(zx).pilotos.get(zxc).equipa + ",=" +  listaCampFile.get(zx).pilotos.get(zxc).ponto);

        }
        for (int i = 0; i < 2; i++) {
            System.out.println("*******************************");
        }
        System.out.println("#### Resultado das Corridas#### ");
        for (int wsx = 0; wsx < listaCampFile.get(zx).corridas.size(); wsx++) {
            System.out.println("Corrida: " +  listaCampFile.get(zx).corridas.get(wsx).nome);
            for (int plm = 0; plm <  listaCampFile.get(zx).corridas.get(wsx).pilotos.size(); plm++) {
                System.out.println( listaCampFile.get(zx).corridas.get(wsx).pilotos.get(plm).nome + ", " + listaCampFile.get(zx).corridas.get(wsx).pilotos.get(plm).equipa+"= "+ listaCampFile.get(zx).corridas.get(wsx).pilotos.get(plm).ponto);
            }

        }
        
        }
        

    }

}




