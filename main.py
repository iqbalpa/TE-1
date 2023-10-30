from data import save_data, load_data
import time
from mergesort import mergesort
from quicksort import quicksort

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

# load data
random9 = load_data("dataset/2-9/random.ob")
sorted9 = load_data("dataset/2-9/sorted.ob")
reversed9 = load_data("dataset/2-9/reversed.ob")
# load_data("dataset/2-13/random.ob")
# load_data("dataset/2-13/sorted.ob")
# load_data("dataset/2-13/reversed.ob")
# load_data("dataset/2-16/random.ob")
# load_data("dataset/2-16/sorted.ob")
# load_data("dataset/2-16/reversed.ob")

print(">>>>>> 2^9 data <<<<<<")
data_dict = {"random": random9, "sorted": sorted9, "reversed": reversed9}
for tipe in data_dict:
    print(f"===== {tipe} =====")
    # merge sort
    print(">>> Mergesort")
    start = time.time()
    sorted_lst = mergesort(data_dict[tipe])
    end = time.time()
    print(f"time taken: {(end-start)}s")
    # quicksort
    print(">>> Quicksort with 2 pivot block partitioning")
    qs_lst = data_dict[tipe].copy()
    start = time.time()
    quicksort(qs_lst, 0, len(qs_lst)-1)
    end = time.time()
    print(f"time taken: {(end-start)}s")
