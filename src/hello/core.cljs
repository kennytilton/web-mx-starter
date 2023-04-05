(ns hello.core
  (:require
    [goog.dom :as gdom]
    [tiltontec.matrix.api
     :refer [make cF cF+ cFn cFonce cI cf-freeze
             mpar mget mset! mswap! mset! with-cc
             fasc fmu fm! minfo]]
    [tiltontec.web-mx.api
     :refer [evt-md tag-dom-create
             img section h1 h2 h3 input footer p a
             span i label ul li div button br
             svg g circle p span div text radialGradient defs stop
             rect ellipse line polyline path polygon script use]]))

;;; --- matrix build ------------------------------------------------

(defn build-hello-matrix []
  (make ::hello
    :mx-dom (div {:style {:display :flex
                          :flex-direction :column
                          :align-items     :center
                          :justify-content :center
                          :gap "1em"}}
              (h2 "The Web/MX&trade; Starter App")
              (img {:alt       "Brian Kernighan, populizer of the `Hello, world.` concept."
                    :src       (cI "image/kernighan.jpeg")
                    :width "25%"
                    :height :auto}
                {:name :hello-pic})
              (p "Brian Kernighan, populizer of the `Hello, world.` app concept.")
              (button
                {:class "button"
                 :disabled false                            ;; included unnecessarily as an example of how to handle boolean HTML attributes
                 :onclick  #(js/alert "Hello, world.")}
                "Speak"))))

(defn main []
  (println "[main]: loading")
  (let [root (gdom/getElement "app")
        ;; ^^^ "app" must be ID of DIV defined in index.html
        app-matrix (build-hello-matrix)
        app-dom (tag-dom-create
                  (mget app-matrix :mx-dom))]
    (set! (.-innerHTML root) nil)
    (gdom/appendChild root app-dom)))

(main)

