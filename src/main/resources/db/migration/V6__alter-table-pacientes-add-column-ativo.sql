ALTER TABLE pacientes ADD ativo TINYINT;
UPDATE pacientes SET ativo = 1;
ALTER TABLE pacientes MODIFY ativo TINYINT NOT NULL;