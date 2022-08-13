package com.hgz.optim.zr;

/**
 * @author hgz
 * @version 1.0
 * @date 2022/7/31 9:30
 */
public abstract class Handler {

    public Handler handler;

    public void next(Handler handler) {
        this.handler = handler;
    }

    public abstract void doHandler(SendVo sendVo);


    public static class Builder {

        private Handler head;

        private Handler tail;

        public Builder addBuilder(Handler handler) {
            if (this.head == null) {
                this.head = this.tail = handler;
                return this;
            }
            this.tail.next(handler);
            this.tail = handler;
            return this;
        }

        public Handler build() {
            return this.head;
        }

    }


}
