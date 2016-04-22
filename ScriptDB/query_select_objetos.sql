select * from mapa_objeto where id_mapa = 24

select o.id_objeto, o.altura, o.largura, o.nome, m.id_mapa_objeto, m.coordenada_x, m.coordenada_y, m.largura, m.altura, m.profundidade, m.angulo 
from objeto o join mapa_objeto m on o.id_objeto = m.id_objeto
where m.id_mapa = 24

select * from objeto