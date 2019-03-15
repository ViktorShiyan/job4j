--Написать запрос получение всех продуктов с типом "СЫР"
select * from product as p, type as t where p.type_id = t.id and t.name = 'Сыр';
--Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"
select * from product as p where p.name like '%мороженое%';
--Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
SELECT p.name, p.price, p.expired_date FROM t_product AS p WHERE
p.expired_date BETWEEN date_trunc('MONTH', CURRENT_TIMESTAMP + '1 month'::INTERVAL)
AND date_trunc('MONTH', CURRENT_TIMESTAMP) + '2 MONTH'::INTERVAL - '1 DAY'::INTERVAL;
--Написать запрос, который выводит самый дорогой продукт.
select * from product as p where p.price = (select max(product.price) from product); 
--Написать запрос, который выводит количество всех продуктов определенного типа.
select count(*) from product as p, type as t where p.type_id = t.id and t.name = 'Сыр'; --или любой другой тип 
--Написать запрос получение всех продуктов с типом "СЫР" и "МОЛОКО"
select * from product as p, type as t where p.type_id = t.id and t.name = 'Сыр' or t.name = 'молоко';
--Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.  
SELECT t.name FROM t_product AS p LEFT JOIN t_type AS t ON t.id = p.type_id GROUP BY t.name HAVING COUNT(p.id) > 10;
--Вывести все продукты и их тип.
select p.name,t.name from product as p, type as t where t.id = p.type_id ;