package com.ferret;

import com.blade.*;

public class App {

    public static void main(String[] args) {
        Blade blade = Blade.me();
        Blade.of().post("/ferret", ctx -> {
            // ctx.bodyToString() prints the post text
            ctx.html("caca");
        }).start();
        Blade.of().listen(9001).start();
    }
}
