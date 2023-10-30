from data import save_data, load_data
import time
from mergesort import mergesort
from quicksort import quicksort
import tracemalloc as trace

# # generate data and save them into pickle
# save_data("dataset/2-9/random.ob", 2**9, "random")
# save_data("dataset/2-9/sorted.ob", 2**9, "sorted")
# save_data("dataset/2-9/reversed.ob", 2**9, "reversed")
# save_data("dataset/2-13/random.ob", 2**13, "random")
# save_data("dataset/2-13/sorted.ob", 2**13, "sorted")
# save_data("dataset/2-13/reversed.ob", 2**13, "reversed")
# save_data("dataset/2-16/random.ob", 2**16, "random")
# save_data("dataset/2-16/sorted.ob", 2**16, "sorted")
# save_data("dataset/2-16/reversed.ob", 2**16, "reversed")

if __name__ == "__main__":
    trace.start()

    # # load data
    random9 = load_data("dataset/2-9/random.ob")
    sorted9 = load_data("dataset/2-9/sorted.ob")
    reversed9 = load_data("dataset/2-9/reversed.ob")
    random13 = load_data("dataset/2-13/random.ob")
    sorted13 = load_data("dataset/2-13/sorted.ob")
    reversed13 = load_data("dataset/2-13/reversed.ob")
    random16 = load_data("dataset/2-16/random.ob")
    sorted16 = load_data("dataset/2-16/sorted.ob")
    reversed16 = load_data("dataset/2-16/reversed.ob")

    print(">>>>>> 2^16 data <<<<<<")
    data_dict = {"random": random16, "sorted": sorted16, "reversed": reversed16}
    for tipe in data_dict:
        print(f"===== {tipe} =====")
        # merge sort
        print(">>> Mergesort")
        trace.start()
        start = time.time()
        sorted_lst = mergesort(data_dict[tipe])
        end = time.time()
        current, peak = trace.get_traced_memory()
        print(f"time taken: {(end-start)}s")
        print(f"memory used: {current} B")
        print(f"peak memory usage: {peak} B")
        trace.stop()

        # quicksort
        print(">>> Quicksort with 2 pivot block partitioning")
        qs_lst = data_dict[tipe].copy()
        trace.start()
        start = time.time()
        quicksort(qs_lst)
        end = time.time()
        current, peak = trace.get_traced_memory()
        print(f"time taken: {(end-start)}s")
        print(f"memory used: {current} B")
        print(f"peak memory usage: {peak} B")
        trace.stop()