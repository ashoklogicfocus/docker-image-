
        FROM stereolabs/zed:3.7-gl-devel-cuda11.4-ubuntu20.04

        WORKDIR /app


        COPY cpp hello_zed_src


        RUN mkdir /app/hello_zed_src/build && cd /app/hello_zed_src/build && \
        cmake -DCMAKE_LIBRARY_PATH=/usr/local/cuda/lib64/stubs \
        -DCMAKE_CXX_FLAGS="-Wl,--allow-shlib-undefined" .. && \
        make


        CMD ["/app/hello_zed_src/build/ZED_Tutorial_1"]