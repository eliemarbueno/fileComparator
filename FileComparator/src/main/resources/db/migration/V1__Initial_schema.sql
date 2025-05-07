CREATE TABLE file_bean (
    file_key VARCHAR(512) PRIMARY KEY,      -- Aumentado para hashes longos
    file_name TEXT NOT NULL,                -- Tamanho ilimitado
    file_size BIGINT NOT NULL,
    file_hash VARCHAR(64),                  -- Para algoritmos como SHA-256
    file_path TEXT NOT NULL,                -- Caminho completo longo
    is_priority BOOLEAN NOT NULL DEFAULT FALSE,
    source_id VARCHAR(100),                 -- Identificação do HD
    last_modified DATETIME,
    logical_path TEXT,                      -- Caminho lógico normalizado
    version INT
);

CREATE INDEX idx_hash_size ON file_bean(file_hash(64), file_size);
CREATE INDEX idx_source ON file_bean(source_id);