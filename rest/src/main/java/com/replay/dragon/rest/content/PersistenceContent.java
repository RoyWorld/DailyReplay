package com.replay.dragon.rest.content;

import com.fasterxml.jackson.core.type.TypeReference;
import com.replay.dragon.rest.util.ContentUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by RoyChan on 2018/10/15.
 */
public abstract class PersistenceContent<E, T extends PersistenceContent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceContent.class);
    protected E content;

    public PersistenceContent() {
    }

    protected abstract TypeReference type();

    protected abstract String savePath();

    protected boolean isHidden() {
        return false;
    }

    protected abstract E defaultValue();

    protected String[] ignoreFields() {
        return null;
    }

    public T save() {
        Object var1 = this.content;
        synchronized (this.content) {
            try {
                ContentUtil.save(this.content, this.savePath(), this.isHidden(), this.ignoreFields());
            } catch (IOException var4) {
                this.log("save error", var4);
            }

            return (T) this;
        }
    }

    public E get() {
        return this.content;
    }

    public T load() {
        try {
            this.content = ContentUtil.get(this.savePath(), this.type());
        } catch (IOException var2) {
            this.log("load error", var2);
        }

        if (this.content == null) {
            this.content = this.defaultValue();
        }

        return (T) this;
    }

    protected void log(String msg, Exception e) {
        LOGGER.error(msg, e);
    }
}
