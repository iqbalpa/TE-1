# # quicksort 2-pivot-block-partitioning
# # REFERENCES:
# # https://arxiv.org/abs/1810.12047
def quicksort(arr):
    stack = []
    stack.append((0, len(arr) - 1))
    while stack:
        start, end = stack.pop()
        if start < end:
            p, q = partition(arr, start, end)
            stack.append((start, p - 1))
            stack.append((p + 1, q - 1))
            stack.append((q + 1, end))
def partition(arr, start, end):
    p = arr[start]
    q = arr[end]
    B = 1024
    block = [0] * B
    i, j, k = start+1, start+1, start+1
    num_p, num_q = 0, 0
    while k < end:
        t = min(B, end - k)
        c = 0
        while c < t:
            block[num_q] = c
            num_q += (q >= arr[k + c])
            c += 1
        c = 0
        while c < num_q:
            arr[j + c], arr[k + block[c]] = arr[k + block[c]], arr[j + c]
            c += 1
        k += t
        c = 0
        while c < num_q:
            block[num_p] = c
            num_p += (p > arr[j + c])
            c += 1
        c = 0
        while c < num_p:
            arr[i], arr[j + block[c]] = arr[j + block[c]], arr[i]
            i += 1
            c += 1
        j += num_q
        num_p, num_q = 0, 0
    arr[i - 1], arr[start] = arr[start], arr[i - 1]
    arr[j], arr[end] = arr[end], arr[j]
    return i - 1, j