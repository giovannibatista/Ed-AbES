--Categoria
INSERT INTO CATEGORIA VALUES (NEXTVAL('CATEGORIA_SEQ'), 'Exterior');
INSERT INTO CATEGORIA VALUES (NEXTVAL('CATEGORIA_SEQ'), 'Interior');
INSERT INTO CATEGORIA VALUES (NEXTVAL('CATEGORIA_SEQ'), 'Espaço');
INSERT INTO CATEGORIA VALUES (NEXTVAL('CATEGORIA_SEQ'), 'Construção');
INSERT INTO CATEGORIA VALUES (NEXTVAL('CATEGORIA_SEQ'), 'Desafio');


--Subcategoria Exterior
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 1, 'Brinquedo');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 1, 'Jardim');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 1, 'Carro');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 1, 'Mesa Externa');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 1, 'Piscina');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 1, 'Poste');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 1, 'Rede');

--Subcategoria Interior
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Abajur');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Armario');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Balança');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Banheiro');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Cadeira');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Cama');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Cortina');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Eletrodoméstico');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Eletronico');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Lixeira');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Louça');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Mesa');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Sofa');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 2, 'Tapete');

--Subcategoria Espaco
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 3, 'Chão');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 3, 'Parede');

--Subcategoria Construcao
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 4, 'Cerca');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 4, 'Coluna');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 4, 'Escada');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 4, 'Janela');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 4, 'Porta');

--Subcategoria Desafio
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 5, 'Ponto');
INSERT INTO SUBCATEGORIA VALUES (NEXTVAL('SUBCATEGORIA_SEQ'), 5, 'Rota');

--Objetos Exterior
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Balanço', '/resources/img/objs/exterior/brinquedo/balanco.png', '/resources/img/objs/exterior/brinquedo/balancomap.png', 'Balanço', 1);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Planta', '/resources/img/objs/exterior/jardim/planta.png', '/resources/img/objs/exterior/jardim/plantamap.png', 'Planta', 2);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Planta2', '/resources/img/objs/exterior/jardim/planta2.png', '/resources/img/objs/exterior/jardim/planta2map.png', 'Planta2', 2);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Planta3', '/resources/img/objs/exterior/jardim/planta3.png', '/resources/img/objs/exterior/jardim/planta3map.png', 'Planta3', 2);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 5, 'Carro', '/resources/img/objs/exterior/carros/car.png', '/resources/img/objs/exterior/carros/carmap.png', 'Carro', 3);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Mesa com cadeiras', '/resources/img/objs/exterior/mesa_externa/mesacadeiras.png', '/resources/img/objs/exterior/mesa_externa/mesacadeirasmap.png', 'Mesa com cadeiras', 4);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 5, 5, 'Piscina', '/resources/img/objs/exterior/piscina/piscina.png', '/resources/img/objs/exterior/piscina/piscinamap.png', 'Piscina', 5);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Poste', '/resources/img/objs/exterior/postes/poste.png', '/resources/img/objs/exterior/postes/postemap.png', 'Poste', 6);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Rede', '/resources/img/objs/exterior/redes/rede.png', '/resources/img/objs/exterior/redes/redemap.png', 'Rede', 7);

--Objetos Interior
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Abajur', '/resources/img/objs/interior/abajur/abajur.png', '/resources/img/objs/interior/abajur/abajurmap.png', 'Abajur', 8);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Abajur', '/resources/img/objs/interior/abajur/abajur2.png', '/resources/img/objs/interior/abajur/abajur2map.png', 'Abajur', 8);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Armario', '/resources/img/objs/interior/armario/brownwardrobe.png', '/resources/img/objs/interior/armario/brownwardrobemap.png', 'Armario', 9);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Armario', '/resources/img/objs/interior/armario/woodenofficedesk.png', '/resources/img/objs/interior/armario/woodenofficedeskmap.png', 'Armario', 9);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Armario', '/resources/img/objs/interior/armario/whiteestante.png', '/resources/img/objs/interior/armario/whiteestantemap.png', 'Armario', 9);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Armario', '/resources/img/objs/interior/armario/woodenestante.png', '/resources/img/objs/interior/armario/woodenestantemap.png', 'Armario', 9);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Armario', '/resources/img/objs/interior/armario/woodenwardrobe.png', '/resources/img/objs/interior/armario/woodenwardrobemap.png', 'Armario', 9);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Balança', '/resources/img/objs/interior/balanca/balanca.png', '/resources/img/objs/interior/balanca/balancamap.png', 'Balanca', 10);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Banheira', '/resources/img/objs/interior/banheiro/banheira.png', '/resources/img/objs/interior/banheiro/banheiramap.png', 'Banheira', 11);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Box', '/resources/img/objs/interior/banheiro/box.png', '/resources/img/objs/interior/banheiro/boxmap.png', 'Box', 11);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Chuveiro', '/resources/img/objs/interior/banheiro/chuveiro.png', '/resources/img/objs/interior/banheiro/chuveiromap.png', 'Chuveiro', 11);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Pia', '/resources/img/objs/interior/banheiro/piaarmario.png', '/resources/img/objs/interior/banheiro/piaarmariomap.png', 'Pia', 11);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Pia', '/resources/img/objs/interior/banheiro/piaarmario2.png', '/resources/img/objs/interior/banheiro/piaarmario2map.png', 'Pia', 11);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Privada', '/resources/img/objs/interior/banheiro/privada.png', '/resources/img/objs/interior/banheiro/privadamap.png', 'Privada', 11);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Cadeira', '/resources/img/objs/interior/cadeira/blackchair.png', '/resources/img/objs/interior/cadeira/blackchairmap.png', 'Cadeira', 12);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Cadeira', '/resources/img/objs/interior/cadeira/blackleatherchair.png', '/resources/img/objs/interior/cadeira/blackleatherchairmap.png', 'Cadeira', 12);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Cadeira', '/resources/img/objs/interior/cadeira/brownchair.png', '/resources/img/objs/interior/cadeira/brownchairmap.png', 'Cadeira', 12);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Cadeira', '/resources/img/objs/interior/cadeira/whitechair.png', '/resources/img/objs/interior/cadeira/whitechairmap.png', 'Cadeira', 12);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Cadeira', '/resources/img/objs/interior/cadeira/woodenchair.png', '/resources/img/objs/interior/cadeira/woodenchairmap.png', 'Cadeira', 12);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Cama de casal', '/resources/img/objs/interior/cama/camacasal.png', '/resources/img/objs/interior/cama/camacasalmap.png', 'Cama de casal', 13);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Cama de solteiro', '/resources/img/objs/interior/cama/camasolteiro.png', '/resources/img/objs/interior/cama/camasolteiromap.png', 'Cama de solteiro', 13);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Cortina', '/resources/img/objs/interior/cortina/blackcurtain.png', '/resources/img/objs/interior/cortina/blackcurtainmap.png', 'Cortina', 14);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 4, 'Cortina', '/resources/img/objs/interior/cortina/whitecurtain.png', '/resources/img/objs/interior/cortina/whitecurtainmap.png', 'Cortina', 14);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Fogao', '/resources/img/objs/interior/eletrodomestico/fogao.png', '/resources/img/objs/interior/eletrodomestico/fogaomap.png', 'Fogao', 15);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Freezer', '/resources/img/objs/interior/eletrodomestico/freezer.png', '/resources/img/objs/interior/eletrodomestico/freezermap.png', 'Freezer', 15);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Geladeira', '/resources/img/objs/interior/eletrodomestico/geladeira.png', '/resources/img/objs/interior/eletrodomestico/geladeiramap.png', 'Geladeira', 15);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 2, 'Microondas', '/resources/img/objs/interior/eletrodomestico/microwave.png', '/resources/img/objs/interior/eletrodomestico/microwavemap.png', 'Microondas', 15);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Torradeira', '/resources/img/objs/interior/eletrodomestico/torradeira.png', '/resources/img/objs/interior/eletrodomestico/torradeiramap.png', 'Torradeira', 15);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Maquina de lavar', '/resources/img/objs/interior/eletrodomestico/washingmachine.png', '/resources/img/objs/interior/eletrodomestico/washingmachinemap.png', 'Maquina de lavar', 15);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Notebook', '/resources/img/objs/interior/eletronico/note.png', '/resources/img/objs/interior/eletronico/notemap.png', 'Notebook', 16);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Computador', '/resources/img/objs/interior/eletronico/pc.png', '/resources/img/objs/interior/eletronico/pcmap.png', 'Computador', 16);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 3, 'Televisão', '/resources/img/objs/interior/eletronico/tv.png', '/resources/img/objs/interior/eletronico/tvmap.png', 'Televisão', 16);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 3, 'Televisão', '/resources/img/objs/interior/eletronico/tv2.png', '/resources/img/objs/interior/eletronico/tv2map.png', 'Televisão', 16);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Telefone', '/resources/img/objs/interior/eletronico/tel.png', '/resources/img/objs/interior/eletronico/telmap.png', 'Telefone', 16);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Lixeira', '/resources/img/objs/interior/lixeira/cesto.png', '/resources/img/objs/interior/lixeira/cestomap.png', 'Lixeira', 17);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Lixeira', '/resources/img/objs/interior/lixeira/trash.png', '/resources/img/objs/interior/lixeira/trashmap.png', 'Lixeira', 17);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Lixeira', '/resources/img/objs/interior/lixeira/trash2.png', '/resources/img/objs/interior/lixeira/trash2map.png', 'Lixeira', 17);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Frigideira', '/resources/img/objs/interior/louca/frigideira.png', '/resources/img/objs/interior/louca/frigideiramap.png', 'Frigideira', 18);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 1, 1, 'Prato', '/resources/img/objs/interior/louca/plate.png', '/resources/img/objs/interior/louca/platemap.png', 'Prato', 18);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Mesa', '/resources/img/objs/interior/mesa/blackdinnertable.png', '/resources/img/objs/interior/mesa/blackdinnertablemap.png', 'Mesa', 19);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Mesa', '/resources/img/objs/interior/mesa/blackroundtable.png', '/resources/img/objs/interior/mesa/blackroundtablemap.png', 'Mesa', 19);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Mesa', '/resources/img/objs/interior/mesa/bluewoodenofficedesk.png', '/resources/img/objs/interior/mesa/bluewoodenofficedeskmap.png', 'Mesa', 19);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Mesa', '/resources/img/objs/interior/mesa/reddinnertable.png', '/resources/img/objs/interior/mesa/reddinnertablemap.png', 'Mesa', 19);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Mesa', '/resources/img/objs/interior/mesa/woodendesk.png', '/resources/img/objs/interior/mesa/woodendeskmap.png', 'Mesa', 19);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Poltrona', '/resources/img/objs/interior/sofa/blackpoltrona.png', '/resources/img/objs/interior/sofa/blackpoltronamap.png', 'Poltrona', 20);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 3, 'Sofa', '/resources/img/objs/interior/sofa/blacksofa.png', '/resources/img/objs/interior/sofa/blacksofamap.png', 'Sofa', 20);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 3, 'Sofa', '/resources/img/objs/interior/sofa/brownsofa.png', '/resources/img/objs/interior/sofa/brownsofamap.png', 'Sofa', 20);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Poltrona', '/resources/img/objs/interior/sofa/graypoltrona.png', '/resources/img/objs/interior/sofa/graypoltronamap.png', 'Poltrona', 20);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Poltrona', '/resources/img/objs/interior/sofa/redpoltrona.png', '/resources/img/objs/interior/sofa/redpoltronamap.png', 'Poltrona', 20);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 3, 'Sofa', '/resources/img/objs/interior/sofa/whitesofa.png', '/resources/img/objs/interior/sofa/whitesofamap.png', 'Sofa', 20);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Tapete', '/resources/img/objs/interior/tapete/blackcarpet.png', '/resources/img/objs/interior/tapete/blackcarpetmap.png', 'Tapete', 21);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Tapete', '/resources/img/objs/interior/tapete/browncarpet.png', '/resources/img/objs/interior/tapete/browncarpetmap.png', 'Tapete', 21);

--Objetos Desafio
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Ponto Fim', '/resources/img/objs/desafio/pontos/pontofim.png', '/resources/img/objs/desafio/pontos/pontofimmap.png', 'Ponto Fim', 29);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 2, 'Ponto Inicio', '/resources/img/objs/desafio/pontos/pontoinicio.png', '/resources/img/objs/desafio/pontos/pontoiniciomap.png', 'Ponto Inicio', 29);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 2, 1, 'Rota', '/resources/img/objs/desafio/rotas/rota.png', '/resources/img/objs/desafio/rotas/rotamap.png', 'Rota', 30);

--Objetos Espaco
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Chão', '/resources/img/objs/espaco/chao/grass.png', '/resources/img/objs/espaco/chao/grassmap.png', 'Chão', 22);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Chão', '/resources/img/objs/espaco/chao/grayfloor.png', '/resources/img/objs/espaco/chao/grayfloormap.png', 'Chão', 22);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Chão', '/resources/img/objs/espaco/chao/stonefloor.png', '/resources/img/objs/espaco/chao/stonefloormap.png', 'Chão', 22);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Chão', '/resources/img/objs/espaco/chao/water.png', '/resources/img/objs/espaco/chao/watermap.png', 'Chão', 22);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Chão', '/resources/img/objs/espaco/chao/whitefloor.png', '/resources/img/objs/espaco/chao/whitefloormap.png', 'Chão', 22);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Chão', '/resources/img/objs/espaco/chao/woodenfloor.png', '/resources/img/objs/espaco/chao/woodenfloormap.png', 'Chão', 22);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 1, 'Parede', '/resources/img/objs/espaco/parede/parede.png', '/resources/img/objs/espaco/parede/paredemap.png', 'Parede', 23);

--Objetos Construcao
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 1, 'Cerca', '/resources/img/objs/construcao/cercas/cerca.png', '/resources/img/objs/construcao/cercas/cercamap.png', 'Cerca', 24);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 3, 'Coluna Circular', '/resources/img/objs/construcao/colunas/colunacircular.png', '/resources/img/objs/construcao/colunas/colunacircularmap.png', 'Coluna Circular', 25);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Escada', '/resources/img/objs/construcao/escadas/escada.png', '/resources/img/objs/construcao/escadas/escadamap.png', 'Escada', 26);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 4, 4, 'Escada Circular', '/resources/img/objs/construcao/escadas/escadacircular.png', '/resources/img/objs/construcao/escadas/escadacircularmap.png', 'Escada Circular', 26);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 1, 'Janela', '/resources/img/objs/construcao/janelas/janela.png', '/resources/img/objs/construcao/janelas/janelamap.png', 'Janela', 27);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 1, 'Porta', '/resources/img/objs/construcao/portas/porta.png', '/resources/img/objs/construcao/portas/portamap.png', 'Porta', 28);
INSERT INTO OBJETO VALUES (NEXTVAL('OBJETO_SEQ'), 3, 1, 'Portao', '/resources/img/objs/construcao/portas/portao.png', '/resources/img/objs/construcao/portas/portamap.png', 'Portao', 28);

--Tipo dos mapas

INSERT INTO TIPO_MAPA VALUES (NEXTVAL('TIPO_MAPA_SEQ'),'Livre');
INSERT INTO TIPO_MAPA VALUES (NEXTVAL('TIPO_MAPA_SEQ'),'Desafio');
