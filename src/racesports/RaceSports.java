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

    public static void main(String[] args) {
        ArrayList<String> leituraFile = new ArrayList<>();
        String fileNome, fileNome2;
        ArrayList<Campeonato> arrayListDeCampeonato = new ArrayList<>();
        Campeonato campeonatoSaida;
        int indexCampeonato = 1;
        int whileControlerCampeonato = 1;
        Campeonato[] vectCampeonato = null;
        Campeonato c2 = new Campeonato();
        Corrida cEntrada;
        int yiu = 0, iu = 0, rep = 0;
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
        String[] vectNomePilotoCorrida = new String[2];

        String lerLinhaSce = null;
        Corrida[] corridaEntrada;
        String lerPiloto;
        String[] vectNomePiloto = new String[2];
        String[] vectNomeCampeonato;
        vectNomeCampeonato = new String[2];

        int numeroPilotosEntrada = 0;

        Scanner in = new Scanner(System.in);
        String fileName, fileName2;
        fileName = "Input.txt";
        
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
        Date nomeVariavel= new Date();
        SimpleDateFormat nv = new SimpleDateFormat("YYYYMMDDhhmmss");
        String outputFormat= nv.format(nomeVariavel);
        
        fileName = "Input.txt";
        fileName2 = outputFormat+".txt";
        
        
        BufferedReader bfr;

        String fileNameTORead, s;
        fileNameTORead = "Input.txt";

        String name, nomeClassificado;
        Campeonato campeonato;

        Piloto piloto1;
        Piloto pilotoCorrida;

        System.out.println("Qual Opera????o deseja Realizar? \n 1- Registar Campeonatos 2 - Ler Ficheiro ");
        switchControl = in.nextInt();
        in.nextLine();
        switch (switchControl) {
            case 1:
                // Registo de Campeonatos
                do {
                    campeonato = new Campeonato();
                    System.out.println("Digite o nome do " + indexCampeonato + "?? campeonato ");
                    campeonato.nome = in.nextLine();
                    System.out.println("Digite o ano de Realiza????o: do " + indexCampeonato + "?? campeonato ");
                    campeonato.anoRealizacao = in.nextInt();
                    in.nextLine();
                    // ##REGISTO DOS PILOTOS
                    do {

                        piloto1 = new Piloto();

                        System.out.println("Digite o nome do: " + p + "?? Piloto");
                        piloto1.nome = in.nextLine();

                        System.out.println("Digite a equipa do: " + p + "?? Piloto");
                        piloto1.equipa = in.nextLine();
                        campeonato.pilotos.add(piloto1);

                        System.out.println(" DESEJA CONTINUAR A ADICIONAR PILOTOS ? \n 0 - Parar / 1 - Continuar ");
                        n = in.nextInt();
                        p++;
                        in.nextLine();
                    } while (n != 0);
                    p = 1;
                    // ####  REGISTO DO SISTEMA DE PONTUA????O 
                    do {
                        int ponto;
                        System.out.println("Digite o " + skp + "?? ponto do sistema de pontua????o do Campeonato:");
                        ponto = in.nextInt();
                        campeonato.sistemaPontuacao.add(ponto);
                        System.out.println("DESEJA CONTINUAR A ADICIONAR PONTOS NO SISTEMA DE PONTUA????O ? \n 0 - Parar / 1 - Continuar ");
                        k = in.nextInt();
                        skp++;
                        in.nextLine();
                    } while (k != 0);
                    skp = 1;
                    // ### REGISTO DO RESULTADO DAS CORRIDAS
                    do {
                        // Instanciando uma corrida 
                        corrida = new Corrida();
                        System.out.println("Digite o nome da: " + h + "?? Corrida");
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
                            System.out.println("Digite o nome do " + t + "?? classificado:");
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
                                    }}
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
                        
                    }while (c != 0);
                        h = 1;

                        // ###Organizar os Pilotos do ArrayList  das Corridas do Campeonato em ordem Decrescente, do Melhor ao pior:
                        /*Corridas do Campeonato: */
                        for (int lop = 0; lop < campeonato.corridas.size(); lop++) {

                            /* Pilotos da corrida n?? lop : */
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
                        // Criar ArrayList de equipas com ArrayList de Corridas e n??o do Campeonato
                        //Cria????o do ArrayList de Equipas 
                        for (int ver = 0; ver < campeonato.pilotos.size(); ver++) {
                            equipa = new Equipa();
                            equipa.ponto = campeonato.pilotos.get(ver).ponto;
                            equipa.nome = campeonato.pilotos.get(ver).equipa;
                            campeonato.equipas.add(equipa);
                        }

                        // Remo????o de Equipes com mesmo nome, se encontrar mais uma ocorr??ncia apaga a segunda, mas mant??m a primeira.
                        for (int ptre = 0; ptre < campeonato.equipas.size(); ptre++) {
                            for (int xsw = ptre + 1; xsw < campeonato.equipas.size(); xsw++) {
                                if (campeonato.equipas.get(ptre).nome.equalsIgnoreCase(campeonato.equipas.get(xsw).nome) && campeonato.equipas.get(ptre).ponto >= campeonato.equipas.get(xsw).ponto) {
                                    campeonato.equipas.remove(xsw);
                                }
                            }

                        }
                        // Organiza????o em  Ordem Decrescente do ArrayList de Pilotos do campeonato, do Melhor ao Pior:
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
                        // Organiza????o em Ordem Decrescente do ArrayList de Equipas, do Melhor ao Pior:
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

                            //Nome do Campeonato, Ano de Realiza??ao:
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
                            //Quantidade de Pontos do Sistema de Pontua????o 'espa??o' Pontos do sistema de pontua????o:
                            bf.write(Integer.toString(arrayListDeCampeonato.get(contadorEscritaCampeonato).sistemaPontuacao.size()) + " ");
                            //Pontos do Sistema de Pontua????o:
                            for (int fg = 0; fg < arrayListDeCampeonato.get(contadorEscritaCampeonato).sistemaPontuacao.size(); fg++) {
                                bf.write(Integer.toString(arrayListDeCampeonato.get(contadorEscritaCampeonato).sistemaPontuacao.get(fg)) + " ");

                            }

                            //Linha em branco:
                            bf.newLine();
                            bf.newLine();
                            // N??mero de corridas:
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
                    // ### ESCRITA DOS RESULTADOS DO CAMPEONATO NUM FICHEIRO DE SA??DA DE ACORDO AO ENUNCIADO

                    try {

                        bf2 = new BufferedWriter(new FileWriter(fileName2));
                        for (int contadorEscritaCampeonatoOutput = 0; contadorEscritaCampeonatoOutput < arrayListDeCampeonato.size(); contadorEscritaCampeonatoOutput++) {
                            bf2.write(arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).nome + ", " + arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).anoRealizacao);

                            bf2.newLine();
                            bf2.newLine();

                            bf2.write("Classifica????o ap??s " + arrayListDeCampeonato.get(contadorEscritaCampeonatoOutput).corridas.size() + " provas realizadas");
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
                      fileNome=in.nextLine();
                      fileNome2=fileNome+".txt";
                      
                //Leitura de um tipo de UM FICHEIRO: 
                try {
                    bfr = new BufferedReader(new FileReader(fileNome2));
                   s=bfr.readLine();
                    while (s != null) {
                        
                    leituraFile.add(s);
                    
                    
                    }

                    bfr.close();

                } catch (IOException loki) {

                    System.out.println(loki.getMessage());

                }

                
                        
                break;

        }
    
        //Leitura de um tipo de UM FICHEIRO: 
    
        }

    }


